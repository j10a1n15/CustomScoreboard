package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI
import tech.thatgravyboat.skyblockapi.api.profile.profile.ProfileAPI

object Bank : ScoreboardElement() {
    override fun getDisplay() = if (ProfileAPI.coop) {
        "Bank: §6${CurrencyAPI.personalBank.format()}§7/§6${CurrencyAPI.coopBank.format()}"
    } else {
        "Bank: §6${CurrencyAPI.coopBank.format()}"
    }

    override fun showIsland() = !SkyblockIsland.inAnyIsland(SkyblockIsland.THE_RIFT)

    override val configLine = "Bank"
}
