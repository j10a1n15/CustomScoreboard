package gay.j10a1n15.customscoreboard.utils

import tech.thatgravyboat.skyblockapi.utils.text.Text
import tech.thatgravyboat.skyblockapi.utils.text.Text.send
import tech.thatgravyboat.skyblockapi.utils.text.TextStyle.url

object ChatUtils {

    fun chat(text: String) {
        Text.of(text).send()
    }

    fun link(text: String, link: String) {
        Text.of(text) { this.url = link }.send()
    }
}
