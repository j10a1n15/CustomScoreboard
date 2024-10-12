package gay.j10a1n15.customscoreboard.feature.customscoreboard.events

import gay.j10a1n15.customscoreboard.utils.NumberUtils.addSeparator
import tech.thatgravyboat.skyblockapi.api.area.hub.FarmhouseAPI
import tech.thatgravyboat.skyblockapi.api.location.SkyBlockIsland
import tech.thatgravyboat.skyblockapi.helpers.McClient
import tech.thatgravyboat.skyblockapi.utils.text.TextProperties.stripped

object EventJacobMedals : Event() {
    override fun getDisplay() = buildList {
        add("§6§lGOLD §fmedals: §6${FarmhouseAPI.goldMedals?.addSeparator()}")
        add("§lSILVER §fmedals: ${FarmhouseAPI.silverMedals?.addSeparator()}")
        add("§c§lBRONZE §fmedals: §c${FarmhouseAPI.bronzeMedals?.addSeparator()}")
    }

    override fun showWhen() = FarmhouseAPI.bronzeMedals != null && McClient.scoreboard.any { medalRegex.matches(it.stripped) }

    override fun showIsland() = SkyBlockIsland.inAnyIsland(SkyBlockIsland.HUB, SkyBlockIsland.GARDEN)

    override val configLine = "Jacob Medals"


    private val medalRegex = ".* medals: \\d+".toRegex()
}
