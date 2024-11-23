package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.feature.customscoreboard.NumberTrackingElement
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI
import tech.thatgravyboat.skyblockapi.api.profile.community.CommunityCenterAPI

object ElementBits : Element(), NumberTrackingElement {
    override var previousAmount: Long = -1
    override var temporaryChangeDisplay: String? = null
    override val numberColor = "§b"

    override fun getDisplay(): String {
        val bits = CurrencyAPI.bits.toLong()
        checkDifference(bits)
        val line = (bits.format() + if (LinesConfig.showBitsAvailable) "§7/§b${CommunityCenterAPI.bitsAvailable.format()}" else "") +
            temporaryChangeDisplay.orEmpty()

        return CustomScoreboardRenderer.formatNumberDisplayDisplay("Bits", line, numberColor)
    }

    override fun showIsland() = !SkyBlockIsland.inAnyIsland(SkyBlockIsland.THE_RIFT, SkyBlockIsland.THE_CATACOMBS)

    override val configLine = "Bits"
}
