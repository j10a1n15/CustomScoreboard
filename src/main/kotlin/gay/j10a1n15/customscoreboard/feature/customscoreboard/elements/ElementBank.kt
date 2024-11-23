package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.NumberTrackingElement
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI
import tech.thatgravyboat.skyblockapi.api.profile.profile.ProfileAPI

object ElementBank : Element(), NumberTrackingElement {
    override var previousAmount: Long = -1
    override var temporaryChangeDisplay: String? = null
    override val numberColor = "§6"

    override fun getDisplay(): String {
        checkDifference(CurrencyAPI.coopBank.toLong())
        val line = when (ProfileAPI.coop) {
            true -> "${CurrencyAPI.personalBank.format()}§7/§6${CurrencyAPI.coopBank.format()}"
            false -> CurrencyAPI.coopBank.format()
        } + temporaryChangeDisplay.orEmpty()

        return CustomScoreboardRenderer.formatNumberDisplayDisplay("Bank", line, numberColor)
    }

    override fun showIsland() = !SkyBlockIsland.inAnyIsland(SkyBlockIsland.THE_RIFT)

    override val configLine = "Bank"
    override val configLineHover = listOf("Cannot be accurate enough,", "so it uses whats in the tablist")
}
