package gay.j10a1n15.customscoreboard.feature

import gay.j10a1n15.customscoreboard.config.CustomScoreboardKeybinds
import gay.j10a1n15.customscoreboard.config.MainConfig
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.time.TickEvent

object KeybindManager {
    var toggleKeyHold = false

    @Subscription
    fun onKeyClick(event: TickEvent) {
        if (CustomScoreboardKeybinds.TOGGLE_KEY.isDown) {
            if (toggleKeyHold) return
            toggleKeyHold = true
            MainConfig.enabled = !MainConfig.enabled
        } else {
            toggleKeyHold = false
        }
    }
}
