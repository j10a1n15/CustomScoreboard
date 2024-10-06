package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object Gems : ScoreboardElement() {
    override fun getDisplay() = "Gems: §a${CurrencyAPI.gems}"

    override fun showIsland() = !SkyblockIsland.inAnyIsland(SkyblockIsland.THE_RIFT)

    override val configLine = "Gems"
}
