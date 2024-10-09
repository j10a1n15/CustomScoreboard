package gay.j10a1n15.customscoreboard.utils.rendering

enum class HorizontalAlignment {
    LEFT,
    CENTER,
    RIGHT;

    override fun toString() = name.lowercase().replaceFirstChar { it.uppercase() }

    fun align(width: Int, screenWidth: Int): Int {
        return when (this) {
            LEFT -> 0
            CENTER -> (screenWidth - width) / 2
            RIGHT -> screenWidth - width
        }
    }
}
