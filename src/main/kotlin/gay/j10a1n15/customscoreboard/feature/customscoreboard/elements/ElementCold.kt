package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import tech.thatgravyboat.skyblockapi.api.area.mining.GlaciteAPI
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland

object ElementCold : Element() {
    override fun getDisplay() = CustomScoreboardRenderer.formatNumberDisplayDisplay("Cold", "${-GlaciteAPI.cold}❄", "§b")

    override fun showWhen() = GlaciteAPI.inGlaciteTunnels() && (GlaciteAPI.cold > 0)

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.DWARVEN_MINES, SkyBlockIsland.MINESHAFT)

    override val configLine = "Cold"
}
