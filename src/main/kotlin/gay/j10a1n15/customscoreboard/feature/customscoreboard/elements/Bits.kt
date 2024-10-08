package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI
import tech.thatgravyboat.skyblockapi.api.profile.community.CommunityCenterAPI

object Bits : ScoreboardElement() {
    override fun getDisplay() = "Bits: §b${CurrencyAPI.bits.format()}§7/§b${CommunityCenterAPI.bitsAvailable.format()}"

    override fun showIsland() = !SkyblockIsland.inAnyIsland(SkyblockIsland.THE_RIFT, SkyblockIsland.THE_CATACOMBS)

    override val configLine: String = "Bits"
}
