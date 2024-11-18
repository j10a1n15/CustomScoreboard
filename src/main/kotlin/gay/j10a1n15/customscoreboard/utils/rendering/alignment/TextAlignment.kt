package gay.j10a1n15.customscoreboard.utils.rendering.alignment

import gay.j10a1n15.customscoreboard.utils.TextUtils.uppercaseFirstChar

enum class TextAlignment {
    START,
    CENTER,
    END;

    override fun toString() = name.uppercaseFirstChar()

    fun align(value: Int, length: Int): Int = when (this) {
        START -> 0
        CENTER -> (length - value) / 2
        END -> length - value
    }
}
