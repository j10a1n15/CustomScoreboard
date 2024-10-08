package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.location.LocationAPI

object ScoreboardElementIsland : ScoreboardElement() {
    override fun getDisplay() = "§7㋖ §a${LocationAPI.island?.formattedName}"

    override fun showIsland() = true

    override val configLine = "Island"
}
