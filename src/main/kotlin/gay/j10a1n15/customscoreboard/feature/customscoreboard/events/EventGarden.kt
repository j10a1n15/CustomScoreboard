package gay.j10a1n15.customscoreboard.feature.customscoreboard.events

import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex

object EventGarden : Event() {
    override fun getDisplay() = formattedLines

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.GARDEN)

    override val configLine = "Dark Auction"


    private var formattedLines = mutableListOf<Component>()

    private val pastingRegex = ComponentRegex("\\s*(?:Barn )?Pasting: [\\d,.]+%?")
    private val cleanupRegex = ComponentRegex("\\s*Cleanup: [\\d,.]*%?")

    @Subscription
    fun onScoreboardUpdate(event: ScoreboardUpdateEvent) {
        formattedLines.clear()
        val lines = event.components
        lines.find { pastingRegex.matches(it) }?.let { formattedLines.add(it) }
        lines.find { cleanupRegex.matches(it) }?.let { formattedLines.add(it) }
    }

}
