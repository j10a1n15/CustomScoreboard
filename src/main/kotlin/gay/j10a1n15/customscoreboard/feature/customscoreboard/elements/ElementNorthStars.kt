package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.NumberTrackingElement
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object ElementNorthStars : Element(), NumberTrackingElement {
    override var previousAmount: Long = -1
    override var temporaryChangeDisplay: String? = null
    override val numberColor = "§d"

    override fun getDisplay(): String {
        checkDifference(CurrencyAPI.northStars)
        val line = CurrencyAPI.northStars.format() + temporaryChangeDisplay.orEmpty()

        return CustomScoreboardRenderer.formatNumberDisplayDisplay("North Stars", line, numberColor)
    }

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.JERRYS_WORKSHOP)

    override val configLine = "North Stars"
}
