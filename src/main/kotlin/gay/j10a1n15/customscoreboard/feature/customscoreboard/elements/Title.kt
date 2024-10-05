package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardLine.Companion.align

object Title : ScoreboardElement() {
    override fun getDisplay() = MainConfig.title.let {
        if (it.useCustomText) it.text align it.alignment else "§6§lSKYBLOCK" align it.alignment
    }

    override val configLine: String = "§6§lSKYBLOCK"
}
