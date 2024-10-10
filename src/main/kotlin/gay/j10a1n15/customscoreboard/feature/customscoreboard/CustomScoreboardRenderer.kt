package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.config.categories.BackgroundConfig
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import gay.j10a1n15.customscoreboard.utils.rendering.HorizontalAlignment
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.drawAlignedTexts
import gay.j10a1n15.customscoreboard.utils.rendering.VerticalAlignment
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
        with(MainConfig) {
            val newX = when (horizontalAlignment) {
                HorizontalAlignment.LEFT -> padding
                HorizontalAlignment.CENTER -> (screenWidth - dimensions.second) / 2
                HorizontalAlignment.RIGHT -> screenWidth - dimensions.second - padding
            }
            val newY = when (verticalAlignment) {
                VerticalAlignment.TOP -> padding
                VerticalAlignment.CENTER -> (screenHeight - dimensions.first) / 2
                VerticalAlignment.BOTTOM -> screenHeight - dimensions.first - padding
            }
            position = newX to newY
        }
    }

    @Subscription
    fun onRender(event: RenderHudEvent) {
        if (!isEnabled()) return
        val display = display ?: return
        if (display.isEmpty()) return

        updatePosition()

        val padding = MainConfig.padding

        val x1 = position.first
        val y1 = position.second

        val x2 = x1 + dimensions.second
        val y2 = y1 + dimensions.first

        event.graphics.fill(x1 - padding, y1 - padding, x2 + padding, y2 + padding, BackgroundConfig.color)

        dimensions = event.graphics.drawAlignedTexts(display, x1, y1)
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
