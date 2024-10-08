package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object Bank : ScoreboardElement() {
    override fun getDisplay() =
        // todo: use isCoop profile
        "Bank: §6${CurrencyAPI.personalBank.format()}" + if (CurrencyAPI.coopBank > 0) " §7/§6${CurrencyAPI.coopBank.format()}" else ""

    override fun showIsland() = !SkyblockIsland.inAnyIsland(SkyblockIsland.THE_RIFT)

    override val configLine = "Bank"
}
