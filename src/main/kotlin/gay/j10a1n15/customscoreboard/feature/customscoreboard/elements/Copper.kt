package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object Copper : ScoreboardElement() {
    override fun getDisplay() = "Copper: §c${CurrencyAPI.copper}"

    override fun showIsland() = SkyblockIsland.inAnyIsland(SkyblockIsland.GARDEN)

    override val configLine = "Copper"
}
