package gay.j10a1n15.customscoreboard.utils.rendering

enum class HorizontalAlignment {
    LEFT,
    CENTER,
    RIGHT;

    override fun toString() = name.lowercase().replaceFirstChar { it.uppercase() }
}
