package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object ElementSoulflow : Element() {
    override fun getDisplay() = "Soulflow: §3${CurrencyAPI.soulflow.format()}"

    override val configLine = "Soulflow"
}
