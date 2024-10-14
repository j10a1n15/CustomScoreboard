package gay.j10a1n15.customscoreboard.feature.customscoreboard.events

import gay.j10a1n15.customscoreboard.utils.TextUtils.toComponent
import net.minecraft.network.chat.Component
import tech.thatgravyboat.skyblockapi.api.area.rift.RiftAPI
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.utils.regex.RegexUtils.anyMatch
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentRegex

object EventRift : Event() {
    override fun getDisplay() = formattedLines

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.THE_RIFT)

    override val configLine = "Rift"


    private var formattedLines = mutableListOf<Component>()

    private val hotdogContestRegex = ComponentRegex("Hot Dog Contest|Eaten: \\d+/\\d+")
    private val aveikxRegex = ComponentRegex("Time spent sitting|with Ävaeìkx: .*")
    private val cluesRegex = ComponentRegex("Clues: \\d+/\\d+")
    private val barryProtestRegex = ComponentRegex("First Up|Find and talk with Barry")
    private val protestorsHandledRegex = ComponentRegex("Protestors handled: \\d+/\\d+")

    private val patterns = listOf(hotdogContestRegex, aveikxRegex, cluesRegex, barryProtestRegex, protestorsHandledRegex)

    private val effigiesRegex = "Effigies: ⧯.*".toRegex()

    @Subscription
    fun onScoreboardUpdate(event: ScoreboardUpdateEvent) {
        formattedLines.clear()
        formattedLines.addAll(
            event.components.filter { component ->
                patterns.any { it.matches(component) }
            },
        )

        // todo: use sbapi
        if (effigiesRegex.anyMatch(event.new)) {
            formattedLines.add(
                buildString {
                    append("Effigies: ")
                    RiftAPI.effieges.map { effigy ->
                        append("§")
                        if (effigy.enabled) "c"
                        else "7"
                        append("⧯")
                    }
                }.toComponent(),
            )
        }
    }
}
