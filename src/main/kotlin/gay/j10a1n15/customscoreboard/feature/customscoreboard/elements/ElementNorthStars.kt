package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object ElementNorthStars : Element() {
    override fun getDisplay() = CustomScoreboardRenderer.formatNumberDisplayDisplay("North Stars", CurrencyAPI.northStars.format(), "§d")

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.JERRYS_WORKSHOP)

    override val configLine = "North Stars"
}
