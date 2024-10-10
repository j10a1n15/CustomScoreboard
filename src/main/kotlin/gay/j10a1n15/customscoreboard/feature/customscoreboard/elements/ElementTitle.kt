package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardLine.Companion.align

object ElementTitle : Element() {
    override fun getDisplay() = MainConfig.title.let {
        if (it.useCustomText) it.text align it.alignment else "§e§lSKYBLOCK" align it.alignment
    }

    override val configLine: String = "§e§lSKYBLOCK"
}
