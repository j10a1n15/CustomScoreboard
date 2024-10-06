package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.Text.addSeparator
import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI
import tech.thatgravyboat.skyblockapi.api.profile.community.CommunityCenterAPI

object Bits : ScoreboardElement() {
    override fun getDisplay() = "Bits: §b${CurrencyAPI.bits.addSeparator()}§7/§b${CommunityCenterAPI.bitsAvailable.addSeparator()}"

    override fun showIsland() = !SkyblockIsland.inAnyIsland(SkyblockIsland.THE_RIFT, SkyblockIsland.THE_CATACOMBS)

    override val configLine: String = "Bits"
}
