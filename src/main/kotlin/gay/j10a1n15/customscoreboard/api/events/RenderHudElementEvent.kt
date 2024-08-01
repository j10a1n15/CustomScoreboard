package gay.j10a1n15.customscoreboard.api.events

import gay.j10a1n15.customscoreboard.api.EventHandler
import gay.j10a1n15.customscoreboard.api.events.base.CancellableEvent

data class RenderHudElementEvent(val element: Element) : CancellableEvent() {

    enum class Element {
        ARMOR,
        HEALTH,
        HUNGER,
        AIR,
        EXPERIENCE,
        HOTBAR,
        JUMP_BAR,
        SCOREBOARD,
        EFFECTS,
    }

    companion object {

        @JvmStatic
        val EVENT = EventHandler<RenderHudElementEvent>()
    }
}