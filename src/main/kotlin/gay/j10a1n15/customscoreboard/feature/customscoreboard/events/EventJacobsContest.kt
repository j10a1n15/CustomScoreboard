package gay.j10a1n15.customscoreboard.feature.customscoreboard.events

import gay.j10a1n15.customscoreboard.utils.Utils.nextAfter
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.info.ScoreboardUpdateEvent
import tech.thatgravyboat.skyblockapi.utils.regex.RegexUtils.anyMatch

object EventJacobsContest : Event() {
    override fun getDisplay() = formattedLines

    override val configLine = "Jacob's Contest"


    private val contestRegex = "Jacob's Contest".toRegex()

    private val formattedLines = mutableListOf<String>()

    @Subscription
    fun onScoreboardUpdate(event: ScoreboardUpdateEvent) {
        formattedLines.clear()

        contestRegex.anyMatch(event.new) {
            formattedLines.add(it.string)
            event.new.nextAfter(it.string)?.let { formattedLines.add(it) }
            event.new.nextAfter(it.string, 2)?.let { formattedLines.add(it) }
            event.new.nextAfter(it.string, 3)?.let { formattedLines.add(it) }
        }

    }
}
