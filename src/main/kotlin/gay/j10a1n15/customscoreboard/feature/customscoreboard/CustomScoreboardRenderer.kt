package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.config.categories.BackgroundConfig
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.drawAlignedTexts
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.fillRect
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
import tech.thatgravyboat.skyblockapi.helpers.McFont

object CustomScoreboardRenderer {

    private var display: List<AlignedText>? = null
    private var currentIslandElements = emptyList<ScoreboardEntry>()
    var currentIslandEvents = emptyList<ScoreboardEventEntry>()
        private set

    private var position: Pair<Int, Int> = 0 to 0
    private var dimensions: Pair<Int, Int> = 0 to 0

    private val screenWidth get() = McClient.window.guiScaledWidth
    private val screenHeight get() = McClient.window.guiScaledHeight

    init {
        ClientTickEvents.START_CLIENT_TICK.register { if (isEnabled()) updateDisplay() }

        MainConfig.appearance.addListener { old, new ->
            updateIslandCache()
        }

        MainConfig.events.addListener { old, new ->
            updateIslandCache()
        }
    }

    private fun updatePosition() {
        with(BackgroundConfig) {
            val width = display?.let { it.maxOf { McFont.width(it.first) } } ?: 0
            val height = display?.let { it.size * McFont.self.lineHeight } ?: 0

            val newX = when (MainConfig.horizontalAlignment) {
                HorizontalAlignment.LEFT -> padding + margin
                HorizontalAlignment.CENTER -> (screenWidth - width) / 2
                HorizontalAlignment.RIGHT -> screenWidth - width - padding - margin
            }
            val newY = when (MainConfig.verticalAlignment) {
                VerticalAlignment.TOP -> padding + margin
                VerticalAlignment.CENTER -> (screenHeight - height) / 2
                VerticalAlignment.BOTTOM -> screenHeight - height - padding - margin
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
        if (!BackgroundConfig.enabled) return
        val padding = BackgroundConfig.padding

        event.graphics.fillRect(
            position.first - padding, position.second - padding,
            dimensions.first + padding * 2, dimensions.second + padding * 2,
            BackgroundConfig.color,
            radius = BackgroundConfig.radius,
        )
    }

    private fun updateIslandCache() {
        currentIslandElements = MainConfig.appearance.get().filter { it.element.showIsland() }
        currentIslandEvents = MainConfig.events.get().filter { it.event.showIsland() }
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

    private fun isEnabled() = LocationAPI.isOnSkyBlock && MainConfig.enabled
    private fun hideHypixelScoreboard() = isEnabled() && MainConfig.hideHypixelScoreboard

}
