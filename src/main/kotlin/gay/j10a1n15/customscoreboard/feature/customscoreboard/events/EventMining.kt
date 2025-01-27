package gay.j10a1n15.customscoreboard.feature.customscoreboard.events

import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardLine.Companion.align
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.TextAlignment
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex

object EventMining : Event() {
    override fun getDisplay() = formattedLines

    override fun showIsland() =
        SkyBlockIsland.inAnyIsland(SkyBlockIsland.DWARVEN_MINES, SkyBlockIsland.CRYSTAL_HOLLOWS, SkyBlockIsland.MINESHAFT)

    override val configLine = "Mining"


    private var formattedLines = mutableListOf<Any>()

    private val powderRegex = ComponentRegex("᠅ (?:Gemstone|Mithril|Glacite)(?: Powder)?.*")
    private val eventRegex = ComponentRegex("Event: .*")
    private val eventZoneRegex = ComponentRegex("Zone: .*")
    private val raffleUselessRegex = ComponentRegex("Find tickets on the|ground and bring them|to the raffle box")
    private val raffleTicketsRegex = ComponentRegex("Tickets: \\d+ §7\\([\\d.,]+%\\)")
    private val rafflePoolRegex = ComponentRegex("Pool: [\\d.,]+")
    private val donUseless = ComponentRegex("Give Tasty Mithril to Don!")
    private val donRemaining = ComponentRegex("Remaining: (?:\\d+ Tasty Mithril|FULL)")
    private val donYourMithril = ComponentRegex("Your Tasty Mithril: \\d+.*")
    private val nearbyPlayers = ComponentRegex("Nearby Players: (?:\\d+|N/A)")
    private val goblinUseless = ComponentRegex("Kill goblins!")
    private val goblinRemaining = ComponentRegex("Remaining: \\d+ goblins?")
    private val goblinYourKills = ComponentRegex("Your kills: \\d+ ☠.*")
    private val mineshaftNotStartedRegex = ComponentRegex("Not started.*")
    private val mineshaftFortunateFreezingRegex = ComponentRegex("Event Bonus: \\+\\d+☘")
    private val fossilDustRegex = ComponentRegex("Fossil Dust: [\\d.,]+.*")
    private val compassRegex = ComponentRegex("Wind Compass")
    private val compassArrowRegex = ComponentRegex("\\s*[⋖⋗≈]+\\s*[⋖⋗≈]*\\s*")

    private val patterns = listOf(
        eventRegex, eventZoneRegex, raffleUselessRegex, raffleTicketsRegex, rafflePoolRegex, donUseless,
        donRemaining, donYourMithril, nearbyPlayers, goblinUseless, goblinRemaining, goblinYourKills, mineshaftNotStartedRegex,
        mineshaftFortunateFreezingRegex, fossilDustRegex, compassRegex,
    )


    @Subscription
    fun onScoreboardUpdate(event: ScoreboardUpdateEvent) {
        formattedLines.clear()
        val patterns = patterns + powderRegex
        formattedLines.addAll(
            event.components.filter { component ->
                patterns.any { it.matches(component) }
            },
        )
        event.components.firstOrNull { compassArrowRegex.matches(it) }?.let {
            formattedLines.add(it align TextAlignment.CENTER)
        }
    }
}
