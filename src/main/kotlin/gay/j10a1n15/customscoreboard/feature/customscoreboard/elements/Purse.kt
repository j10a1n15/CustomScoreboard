package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.Text.addSeparator
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object Purse : ScoreboardElement() {
    override fun getDisplay() = "Purse: §6${CurrencyAPI.purse.addSeparator()}"

    override val configLine: String = "Purse"
}