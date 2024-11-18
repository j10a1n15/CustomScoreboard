package gay.j10a1n15.customscoreboard.utils.rendering.alignment

import gay.j10a1n15.customscoreboard.utils.TextUtils.uppercaseFirstChar

enum class HorizontalAlignment {
    LEFT,
    CENTER,
    RIGHT;

    override fun toString() = name.uppercaseFirstChar()
}
