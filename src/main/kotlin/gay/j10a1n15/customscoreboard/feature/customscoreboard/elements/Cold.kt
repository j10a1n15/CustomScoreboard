package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.area.mining.GlaciteAPI
import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland

object Cold : ScoreboardElement() {
    override fun getDisplay() = "Cold: §b${GlaciteAPI.cold}❄"

    // todo: mineshaft
    override fun showIsland() = SkyblockIsland.inAnyIsland(SkyblockIsland.DWARVEN_MINES /*SkyblockIsland.MINESHAFT*/)

    override val configLine = "cold"
}
