package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.config.categories.BackgroundConfig
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.drawAlignedTexts
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.HorizontalAlignment
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.VerticalAlignment
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.location.IslandChangeEvent
import tech.thatgravyboat.skyblockapi.api.events.render.HudElement
import tech.thatgravyboat.skyblockapi.api.events.render.RenderHudElementEvent
import tech.thatgravyboat.skyblockapi.api.events.render.RenderHudEvent
import tech.thatgravyboat.skyblockapi.api.location.LocationAPI
import tech.thatgravyboat.skyblockapi.helpers.McClient

object CustomScoreboardRenderer {

    private var display: List<AlignedText>? = null
    private var currentIslandElements = emptyList<ScoreboardEntry>()

    private var position: Pair<Int, Int> = 0 to 0
    private var dimensions: Pair<Int, Int> = 0 to 0

    private val screenWidth get() = McClient.window.guiScaledWidth
    private val screenHeight get() = McClient.window.guiScaledHeight

    init {
        ClientTickEvents.START_CLIENT_TICK.register { updateDisplay() }

        MainConfig.appearance.addListener { old, new ->
            updateIslandCache()
            updateDisplay()
        }
    }

    private fun updatePosition() {
        with(BackgroundConfig) {
            val width = display?.let { it.maxOf { McClient.self.font.width(it.first) } } ?: 0
            val height = display?.let { it.size * McClient.self.font.lineHeight } ?: 0

            val newX = when (MainConfig.horizontalAlignment) {
                HorizontalAlignment.LEFT -> padding
                HorizontalAlignment.CENTER -> (screenWidth - width) / 2
                HorizontalAlignment.RIGHT -> screenWidth - width - padding
            }
            val newY = when (MainConfig.verticalAlignment) {
                VerticalAlignment.TOP -> padding
                VerticalAlignment.CENTER -> (screenHeight - height) / 2
                VerticalAlignment.BOTTOM -> screenHeight - height - padding
            }
            position = newX to newY
            dimensions = width to height
        }
    }

    @Subscription
    fun onRender(event: RenderHudEvent) {
        if (!isEnabled()) return
        val display = display ?: return
        if (display.isEmpty()) return

        updatePosition()
        renderBackground(event)
        event.graphics.drawAlignedTexts(display, position.first, position.second, MainConfig.textShadow)
    }

    private fun renderBackground(event: RenderHudEvent) {
        val padding = BackgroundConfig.padding

        val x1 = position.first
        val y1 = position.second

        val x2 = x1 + dimensions.first
        val y2 = y1 + dimensions.second

        event.graphics.fill(x1 - padding, y1 - padding, x2 + padding, y2 + padding, BackgroundConfig.color)
    }

    private fun updateIslandCache() {
        currentIslandElements = MainConfig.appearance.get().filter { it.element.showIsland() }
    }

    private fun updateDisplay() {
        if (!isEnabled()) return
        display = createDisplay()
    }

    private fun createDisplay() = buildList {
        for (element in currentIslandElements) {
            addAll(element.element.getLines().map { it.toAlignedText() })
        }
    }

    @Subscription
    fun onRenderHudElement(event: RenderHudElementEvent) {
        if (event.element == HudElement.SCOREBOARD && hideHypixelScoreboard()) {
            event.cancel()
        }
    }

    @Subscription
    fun onIslandChange(event: IslandChangeEvent) {
        updateIslandCache()
    }

    private fun isEnabled() = LocationAPI.isOnSkyblock && MainConfig.enabled
    private fun hideHypixelScoreboard() = isEnabled() && MainConfig.hideHypixelScoreboard

}
