package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import tech.thatgravyboat.skyblockapi.api.area.mining.GlaciteAPI
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.party.PartyAPI

object ElementParty : Element() {
    override fun getDisplay() = buildList {
        add("§9Party: ${PartyAPI.size}")
        PartyAPI.members.forEach {
            add("§7- §f${it.name}")
        }
    }

    override fun showWhen() = PartyAPI.size > 0 && if (SkyBlockIsland.THE_CATACOMBS.inIsland()) {
        true
    } else {
        if (LinesConfig.showPartyEverywhere) {
            true
        } else {
            SkyBlockIsland.inAnyIsland(
                SkyBlockIsland.DUNGEON_HUB,
                SkyBlockIsland.CRIMSON_ISLE,
            ) || GlaciteAPI.inGlaciteTunnels()
        }
    }

    override val configLine = "Party"
}
