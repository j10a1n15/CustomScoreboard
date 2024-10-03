package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.config.category.TitleAndFooterConfig
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardLine.Companion.align
import gay.j10a1n15.customscoreboard.utils.rendering.Alignment

object Title : ScoreboardElement() {
    override fun getDisplay() = "§6§lSKYBLOCK" align TitleAndFooterConfig.titleAlignment

    override val configLine: String = "§6§lSKYBLOCK"
}