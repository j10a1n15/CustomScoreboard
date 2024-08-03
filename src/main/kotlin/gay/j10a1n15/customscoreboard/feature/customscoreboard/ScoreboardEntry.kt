package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.Footer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.ScoreboardElement
import gay.j10a1n15.customscoreboard.feature.customscoreboard.elements.Title

enum class ScoreboardEntry(val element: ScoreboardElement) {
    TITLE(Title),
    FOOTER(Footer),
    ;

    override fun toString() = element.configLine
}