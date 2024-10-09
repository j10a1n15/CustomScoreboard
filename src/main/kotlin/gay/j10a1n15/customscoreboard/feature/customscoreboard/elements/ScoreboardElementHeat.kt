package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.area.mining.HollowsAPI
import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland
import tech.thatgravyboat.skyblockapi.helpers.McPlayer

object ScoreboardElementHeat : ScoreboardElement() {
    override fun getDisplay() = buildString {
        append("Heat: ")
        if (HollowsAPI.immuneToHeat) append("§6IMMUNE")
        else append("§c${HollowsAPI.heat}♨")
    }

    override fun showWhen() = HollowsAPI.heat != 0 || McPlayer.self?.y?.let { it <= 64 } == true

    override fun showIsland() = SkyblockIsland.inAnyIsland(SkyblockIsland.CRYSTAL_HOLLOWS)

    override val configLine = "Heat"
}
