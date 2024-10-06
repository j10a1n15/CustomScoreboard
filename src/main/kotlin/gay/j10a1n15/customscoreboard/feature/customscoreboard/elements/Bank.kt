package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.api.profile.CurrencyAPI

object Bank : ScoreboardElement() {
    override fun getDisplay() =
        "Bank: §6${CurrencyAPI.personalBank}" + if (CurrencyAPI.coopBank > 0) " §7/§6${CurrencyAPI.coopBank}" else ""

    override fun showIsland() = !SkyblockIsland.inAnyIsland(SkyblockIsland.THE_RIFT)

    override val configLine = "Bank"
}
