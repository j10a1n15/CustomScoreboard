package gay.j10a1n15.customscoreboard.feature.customscoreboard.events

import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex

object EventKuudra : Event() {
    override fun getDisplay() = formattedLines

    // todo sbapi
    //override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.KUUDRA)

    override val configLine = "Kuudra"


    private var formattedLines = mutableListOf<Component>()

    private val autoCloseRegex = ComponentRegex("Auto-closing in: [\\d+:,.]+")
    private val startingInRegex = ComponentRegex("Starting in: [\\d+:,.]+")
    private val timeElapsedRegex = ComponentRegex("Time Elapsed: (?<time>(\\w+[ydhms] ?)+)")
    private val instanceShutdownRegex = ComponentRegex("Instance Shutdown In: (?<time>(?:\\w+[ydhms] ?)+)")
    private val waveRegex = ComponentRegex("Wave: \\d+(?: - \\d+:\\d+)?")
    private val tokensRegex = ComponentRegex("Tokens: [\\w,]+")
    private val submergesRegex = ComponentRegex("Submerges In: [\\w\\s?]+")

    private val patterns =
        listOf(autoCloseRegex, startingInRegex, timeElapsedRegex, instanceShutdownRegex, waveRegex, tokensRegex, submergesRegex)


    @Subscription
    fun onScoreboardUpdate(event: ScoreboardUpdateEvent) {
        formattedLines.clear()
        formattedLines.addAll(
            event.components.filter { component ->
                patterns.any { it.matches(component) }
            },
        )
    }
}
