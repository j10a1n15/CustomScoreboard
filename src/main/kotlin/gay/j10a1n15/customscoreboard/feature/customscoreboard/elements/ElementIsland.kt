package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.location.LocationAPI

object ElementIsland : Element() {
    override fun getDisplay() = "§7㋖ §a${LocationAPI.island}"

    override fun showWhen() = LocationAPI.island != null

    override fun showIsland() = true

    override val configLine = "Island"
}
