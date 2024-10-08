package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object Motes : ScoreboardElement() {
    override fun getDisplay() = "Motes: §d${CurrencyAPI.motes.format()}"

    override fun showIsland() = SkyblockIsland.inAnyIsland(SkyblockIsland.THE_RIFT)

    override val configLine: String = "Motes"
}
