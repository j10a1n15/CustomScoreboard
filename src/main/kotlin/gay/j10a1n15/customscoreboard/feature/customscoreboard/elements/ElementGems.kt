package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object ElementGems : Element() {
    override fun getDisplay() = CustomScoreboardRenderer.formatNumberDisplayDisplay("Gems", CurrencyAPI.gems.format(), "§a")

    override fun showIsland() = !SkyBlockIsland.inAnyIsland(SkyBlockIsland.THE_RIFT)

    override val configLine = "Gems"
}
