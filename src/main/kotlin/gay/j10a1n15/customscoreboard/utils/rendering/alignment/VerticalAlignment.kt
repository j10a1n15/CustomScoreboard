package gay.j10a1n15.customscoreboard.utils.rendering.alignment

import gay.j10a1n15.customscoreboard.utils.TextUtils.uppercaseFirstChar

enum class VerticalAlignment {
    TOP,
    CENTER,
    BOTTOM;

    override fun toString() = name.uppercaseFirstChar()
}
