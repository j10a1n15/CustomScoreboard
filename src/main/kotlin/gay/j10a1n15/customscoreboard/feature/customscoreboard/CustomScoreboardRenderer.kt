package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import gay.j10a1n15.customscoreboard.utils.rendering.HorizontalAlignment
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.drawAlignedTexts
import gay.j10a1n15.customscoreboard.utils.rendering.VerticalAlignment
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.location.IslandChangeEvent
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
        val newX = when (MainConfig.horizontalAlignment) {
            HorizontalAlignment.LEFT -> 0
            HorizontalAlignment.CENTER -> (screenWidth - dimensions.first) / 2
            HorizontalAlignment.RIGHT -> screenWidth - dimensions.first
        }
        val newY = when (MainConfig.verticalAlignment) {
            VerticalAlignment.TOP -> 0
            VerticalAlignment.CENTER -> (screenHeight - dimensions.second) / 2
            VerticalAlignment.BOTTOM -> screenHeight - dimensions.second
        }

        position = newX to newY
    }

    @Subscription
    fun onIslandChange(event: IslandChangeEvent) {
        updateIslandCache()
    }

    @Subscription
    fun onRender(event: RenderHudEvent) {
        if (!isEnabled()) return
        val display = display ?: return
        if (display.isEmpty()) return

        updatePosition()

        dimensions = event.graphics.drawAlignedTexts(display, position.first, position.second)
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

    private fun isEnabled() = LocationAPI.isOnSkyblock && MainConfig.enabled

}
