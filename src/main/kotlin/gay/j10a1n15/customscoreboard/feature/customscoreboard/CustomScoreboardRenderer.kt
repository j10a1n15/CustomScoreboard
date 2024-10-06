package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import gay.j10a1n15.customscoreboard.utils.rendering.RenderUtils.drawAlignedTexts
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.location.IslandChangeEvent
import tech.thatgravyboat.skyblockapi.api.events.render.RenderHudEvent
import tech.thatgravyboat.skyblockapi.api.location.LocationAPI

object CustomScoreboardRenderer {

    private var display: List<AlignedText>? = null

    // TODO: Fix this being empty on skyblock join
    private var currentIslandElements = emptyList<ScoreboardEntry>()

    init {
        ClientTickEvents.START_CLIENT_TICK.register { updateDisplay() }

        MainConfig.appearance.addListener { old, new ->
            updateIslandCache()
            updateDisplay()
        }
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

        event.graphics.drawAlignedTexts(
            display,
            100,
            100,
        )
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
