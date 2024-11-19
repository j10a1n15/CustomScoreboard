package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardLine.Companion.align

object ElementFooter : Element() {
    override fun getDisplay() = MainConfig.footer.let { f ->
        if (f.useCustomText) f.text.formatFooter().map { it align f.alignment } else "§ewww.hypixel.net" align f.alignment
    }

    override val configLine: String = "§ewww.hypixel.net"

    fun String.formatFooter() = replace("&&", "§").split("\\n")
}
