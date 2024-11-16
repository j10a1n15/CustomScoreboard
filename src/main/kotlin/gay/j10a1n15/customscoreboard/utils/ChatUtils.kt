package gay.j10a1n15.customscoreboard.utils

import gay.j10a1n15.customscoreboard.utils.TextUtils.toComponent
import tech.thatgravyboat.skyblockapi.helpers.McPlayer
import tech.thatgravyboat.skyblockapi.utils.text.Text
import tech.thatgravyboat.skyblockapi.utils.text.TextStyle.url

object ChatUtils {

    fun chat(text: String) {
        McPlayer.self?.displayClientMessage(text.toComponent(), true)
    }

    fun link(text: String, link: String) {
        McPlayer.self?.displayClientMessage(Text.of(text) { this.url = link }, true)
    }
}
