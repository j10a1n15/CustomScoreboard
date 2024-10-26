package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.feature.customscoreboard.CustomScoreboardRenderer
import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.area.rift.RiftAPI
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland

object ElementMotes : Element() {
    override fun getDisplay() = CustomScoreboardRenderer.formatNumberDisplayDisplay("Motes", RiftAPI.motes.format(), "§d")

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.THE_RIFT)

    override val configLine: String = "Motes"
}
