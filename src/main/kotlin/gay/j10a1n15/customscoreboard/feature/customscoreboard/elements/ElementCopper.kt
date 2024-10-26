package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object ElementCopper : Element() {
    override fun getDisplay() = CustomScoreboardRenderer.formatNumberDisplayDisplay("Copper", CurrencyAPI.copper.format(), "§c")

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.GARDEN)

    override val configLine = "Copper"
}
