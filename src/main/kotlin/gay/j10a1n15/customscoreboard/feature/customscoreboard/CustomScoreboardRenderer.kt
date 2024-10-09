package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.location.IslandChangeEvent
import tech.thatgravyboat.skyblockapi.api.location.LocationAPI

object CustomScoreboardRenderer {

    var display: List<AlignedText>? = null
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

    fun isEnabled() = LocationAPI.isOnSkyblock && MainConfig.enabled

}
