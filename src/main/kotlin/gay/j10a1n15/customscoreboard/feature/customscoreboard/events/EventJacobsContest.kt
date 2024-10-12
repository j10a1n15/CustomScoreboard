package gay.j10a1n15.customscoreboard.feature.customscoreboard.events

import gay.j10a1n15.customscoreboard.utils.Utils.nextAfter
import tech.thatgravyboat.skyblockapi.helpers.McClient

object EventJacobsContest : Event() {
    // TODO: use scoreboard update event
    override fun getDisplay() = buildList {
        val lines = McClient.scoreboard
        add("§eJacob's Contest")
        lines.nextAfter("Jacob's Contest")?.let { add(it) }
        lines.nextAfter("Jacob's Contest", 2)?.let { add(it) }
        lines.nextAfter("Jacob's Contest", 3)?.let { add(it) }
    }

    override val configLine = "Jacob's Contest"
}
