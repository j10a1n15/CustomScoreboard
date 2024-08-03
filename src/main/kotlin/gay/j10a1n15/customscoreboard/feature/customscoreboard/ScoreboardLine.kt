package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.utils.Text.toComponent
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import gay.j10a1n15.customscoreboard.utils.rendering.Alignment

data class ScoreboardLine(
    val display: String,
    val alignment: Alignment = DEFAULT_ALIGNMENT,
) {

    fun toAlignedText(): AlignedText = display.toComponent() to alignment

    companion object {
        private val DEFAULT_ALIGNMENT get() = Alignment.START//displayConfig.textAlignment

        fun String.align(): ScoreboardLine = ScoreboardLine(this, DEFAULT_ALIGNMENT)

        infix fun String.align(alignment: Alignment): ScoreboardLine = ScoreboardLine(this, alignment)

        internal fun getElementsFromAny(element: Any?): List<ScoreboardLine> = when (element) {
            null -> listOf()
            is List<*> -> element.mapNotNull { it?.toScoreboardElement() }
            else -> listOfNotNull(element.toScoreboardElement())
        }

        private fun Any.toScoreboardElement(): ScoreboardLine? = when (this) {
            is String -> this.align()
            is ScoreboardLine -> this
            else -> null
        }
    }
}