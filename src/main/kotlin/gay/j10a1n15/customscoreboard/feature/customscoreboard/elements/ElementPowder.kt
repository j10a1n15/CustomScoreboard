package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.utils.NumberUtils.format
import tech.thatgravyboat.skyblockapi.api.area.mining.PowderAPI
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland

object ElementPowder : Element() {
    override fun getDisplay() = buildList {
        add("§9Powder")
        // todo: option for full powder
        add(" §7- §fMithril: §2${PowderAPI.mithril.format()}")
        add(" §7- §fGemstone: §d${PowderAPI.gemstone.format()}")
        add(" §7- §fGlacite: §b${PowderAPI.glacite.format()}")
    }

    override fun showIsland() =
        SkyBlockIsland.inAnyIsland(SkyBlockIsland.DWARVEN_MINES, SkyBlockIsland.CRYSTAL_HOLLOWS, SkyBlockIsland.MINESHAFT)

    override val configLine = "Powder"
}
