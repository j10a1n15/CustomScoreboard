package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import tech.thatgravyboat.skyblockapi.api.area.mining.GlaciteAPI
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.api.profile.party.PartyAPI

object ElementParty : Element() {
    override fun getDisplay() = buildList {
        val list = PartyAPI.members.distinctBy { it.name }
        add("§9Party (${list.size})")
        if (LinesConfig.showPartyLeader) {
            PartyAPI.leader?.let {
                add("§7- §f${it.name} §e♚")
            }
        }

        list
            .take(LinesConfig.maxPartyMembers)
            .filter { LinesConfig.showPartyLeader && it != PartyAPI.leader }
            .forEach {
                add("§7- §f${it.name}")
            }
    }

    override fun showWhen() = PartyAPI.size > 0 && when {
        SkyBlockIsland.THE_CATACOMBS.inIsland() -> false
        LinesConfig.showPartyEverywhere -> true
        else -> SkyBlockIsland.inAnyIsland(
            SkyBlockIsland.DUNGEON_HUB,
            SkyBlockIsland.CRIMSON_ISLE,
        ) || GlaciteAPI.inGlaciteTunnels()
    }

    override val configLine = "Party"
}
