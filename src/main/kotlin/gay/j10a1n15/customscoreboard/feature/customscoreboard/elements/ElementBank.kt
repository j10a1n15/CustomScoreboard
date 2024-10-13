package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI
import tech.thatgravyboat.skyblockapi.api.profile.profile.ProfileAPI

object ElementBank : Element() {
    override fun getDisplay() = if (ProfileAPI.coop) {
        "Bank: §6${CurrencyAPI.personalBank.format()}§7/§6${CurrencyAPI.coopBank.format()}"
    } else {
        "Bank: §6${CurrencyAPI.coopBank.format()}"
    }

    override fun showIsland() = !SkyBlockIsland.inAnyIsland(SkyBlockIsland.THE_RIFT)

    override val configLine = "Bank"
    override val configLineHover = listOf("Cannot be accurate enough,", "so it uses whats in the tablist")
}
