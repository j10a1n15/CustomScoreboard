package gay.j10a1n15.customscoreboard.utils.rendering

enum class Alignment {
    START,
    CENTER,
    END;

    fun align(value: Int, length: Int): Int = when (this) {
        START -> 0
        CENTER -> (length - value) / 2
        END -> length - value
    }
}