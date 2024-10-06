package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.location.SkyblockIsland

object Heat : ScoreboardElement() {
    // todo: hollows api
    override fun getDisplay() = "Heat: 0"

    override fun showIsland() = SkyblockIsland.inAnyIsland(SkyblockIsland.CRYSTAL_HOLLOWS)

    override val configLine = "Heat"
}
