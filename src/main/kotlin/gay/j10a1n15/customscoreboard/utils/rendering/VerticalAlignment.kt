package gay.j10a1n15.customscoreboard.utils.rendering

enum class VerticalAlignment {
    TOP,
    CENTER,
    BOTTOM;

    override fun toString() = name.lowercase().replaceFirstChar { it.uppercase() }

    fun align(height: Int, screenHeight: Int): Int {
        return when (this) {
            TOP -> 0
            CENTER -> (screenHeight - height) / 2
            BOTTOM -> screenHeight - height
        }
    }
}
