package gay.j10a1n15.customscoreboard.feature.customscoreboard

import gay.j10a1n15.customscoreboard.utils.TextUtils.toComponent
import gay.j10a1n15.customscoreboard.utils.rendering.AlignedText
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.TextAlignment
import net.minecraft.network.chat.Component

data class ScoreboardLine(
    val display: Component,
    val alignment: TextAlignment = DEFAULT_ALIGNMENT,
) {

    fun toAlignedText(): AlignedText = display to alignment

    companion object {
        private val DEFAULT_ALIGNMENT get() = TextAlignment.START//displayConfig.textAlignment

        fun String.align(): ScoreboardLine = ScoreboardLine(this.toComponent(), DEFAULT_ALIGNMENT)

        fun Component.align(): ScoreboardLine = ScoreboardLine(this, DEFAULT_ALIGNMENT)

        infix fun String.align(alignment: TextAlignment): ScoreboardLine = ScoreboardLine(this.toComponent(), alignment)

        infix fun Component.align(alignment: TextAlignment): ScoreboardLine = ScoreboardLine(this, alignment)

        internal fun getElementsFromAny(element: Any?): List<ScoreboardLine> = when (element) {
            null -> listOf()
            is Component -> listOfNotNull(element.toScoreboardElement())
            is List<*> -> element.mapNotNull { it?.toScoreboardElement() }
            else -> listOfNotNull(element.toScoreboardElement())
        }

        private fun Any.toScoreboardElement(): ScoreboardLine? = when (this) {
            is String -> this.toComponent().align()
            is ScoreboardLine -> this
            is Component -> this.align()
            else -> null
        }
    }
}
