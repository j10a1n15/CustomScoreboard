package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.NumberTrackingElement
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object ElementSoulflow : Element(), NumberTrackingElement {
    override var previousAmount: Long = CurrencyAPI.soulflow
    override var temporaryChangeDisplay: String? = null
    override val numberColor = "§3"

    override fun getDisplay(): String {
        checkDifference(CurrencyAPI.soulflow)
        val line = CurrencyAPI.soulflow.format() + temporaryChangeDisplay.orEmpty()

        return CustomScoreboardRenderer.formatNumberDisplayDisplay("Soulflow", line, numberColor)
    }

    override fun showIsland() = !SkyBlockIsland.inAnyIsland(SkyBlockIsland.THE_RIFT)

    override val configLine = "Soulflow"
    override val configLineHover = listOf("Requires the Soulflow option enabled in the Profile category in /tablist.")
}
