package gay.j10a1n15.customscoreboard.api.events.base

abstract class CancellableEvent(
    private var isCancelled: Boolean = false
) {

    fun cancel() {
        isCancelled = true
    }

    fun isCancelled() = isCancelled
}