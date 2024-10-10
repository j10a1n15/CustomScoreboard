package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object ElementNorthStars : Element() {
    override fun getDisplay() = "North Stars: §d${CurrencyAPI.northStars.format()}"

    override fun showIsland() = SkyblockIsland.inAnyIsland(SkyblockIsland.JERRYS_WORKSHOP)

    override val configLine = "North Stars"
}
