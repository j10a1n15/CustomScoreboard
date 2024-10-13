package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer.currentIslandEvents

object ElementEvents : Element() {
    override fun getDisplay() =
        if (LinesConfig.showAllActiveEvents) currentIslandEvents.mapNotNull { it.event.getLines().takeIf { !it.isEmpty() } }.flatten()
        else currentIslandEvents.firstNotNullOfOrNull { it.event.getLines().takeIf { !it.isEmpty() } }

    override val configLine = "Events"
    override val configLineHover = listOf(
        "Please don't remove this element.",
        "It's used to display all kind of not-that-important information.",
        "See the events draggable list below.",
        "",
        "If I see a support question saying \"Why do I not have Dungeon lines\" and you removed this, I will cry.",
    )
}
