package gay.j10a1n15.customscoreboard.utils.rendering

enum class VerticalAlignment {
    TOP,
    CENTER,
    BOTTOM;

    override fun toString() = name.lowercase().replaceFirstChar { it.uppercase() }
}
