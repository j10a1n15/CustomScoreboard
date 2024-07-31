package gay.j10a1n15.customscoreboard.api

typealias EventInvoker<T> = T.() -> Unit

class EventHandler<T> {

    private val listeners = mutableListOf<Pair<Int, EventInvoker<T>>>()
    private var recalculate = true

    fun addListener(listener: EventInvoker<T>) {
        addListener(0, listener)
    }

    fun addListener(priority: Int, listener: EventInvoker<T>) {
        listeners.add(priority to listener)
        recalculate = true
    }

    fun removeListener(listener: EventInvoker<T>) {
        listeners.removeIf { it.second == listener }
    }

    fun fire(event: T): T {
        if (recalculate) {
            listeners.sortBy { it.first }
            recalculate = false
        }
        listeners.forEach { it.second(event) }
        return event
    }
}