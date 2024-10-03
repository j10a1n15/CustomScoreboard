package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.Text.addSeparator
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object Bits : ScoreboardElement() {
    override fun getDisplay() = "Bits: §b${CurrencyAPI.bits.addSeparator()}"

    override val configLine: String = "Bits"
}