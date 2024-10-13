package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.config.categories.LinesConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardLine.Companion.align
import tech.thatgravyboat.skyblockapi.helpers.McClient

object ElementTitle : Element() {
    override fun getDisplay() = when {
        LinesConfig.useHypixelTitle -> McClient.scoreboardTitle
        MainConfig.title.useCustomText -> MainConfig.title.text
        else -> "§e§lSkyBlock"
    }?.align(MainConfig.title.alignment)

    override val configLine: String = "§e§lSkyBlock"
}
