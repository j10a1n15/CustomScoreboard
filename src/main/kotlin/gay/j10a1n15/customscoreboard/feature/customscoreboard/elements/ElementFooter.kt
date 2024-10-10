package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardLine.Companion.align

object ElementFooter : Element() {
    override fun getDisplay() = MainConfig.footer.let {
        if (it.useCustomText) it.text align it.alignment else "§ewww.hypixel.net" align it.alignment
    }

    override val configLine: String = "§ewww.hypixel.net"
}
