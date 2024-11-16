package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.NumberTrackingElement
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object ElementCopper : Element(), NumberTrackingElement {
    override var previousAmount = CurrencyAPI.copper
    override var temporaryChangeDisplay: String? = null
    override val numberColor = "§c"

    override fun getDisplay(): String {
        checkDifference(CurrencyAPI.copper)
        val line = CurrencyAPI.copper.format() + temporaryChangeDisplay.orEmpty()

        return CustomScoreboardRenderer.formatNumberDisplayDisplay("Copper", line, numberColor)
    }

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.GARDEN)

    override val configLine = "Copper"
}
