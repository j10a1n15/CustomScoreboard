package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.NumberTrackingElement
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object ElementGems : Element(), NumberTrackingElement {
    override var previousAmount = CurrencyAPI.gems
    override var temporaryChangeDisplay: String? = null
    override val numberColor = "§a"

    override fun getDisplay(): String {
        checkDifference(CurrencyAPI.gems)
        val line = CurrencyAPI.gems.format() + temporaryChangeDisplay.orEmpty()

        return CustomScoreboardRenderer.formatNumberDisplayDisplay("Gems", line, numberColor)
    }

    override fun showIsland() = !SkyBlockIsland.inAnyIsland(SkyBlockIsland.THE_RIFT)

    override val configLine = "Gems"
}
