package gay.j10a1n15.customscoreboard.utils

import net.minecraft.network.chat.Component

object Text {

    fun String.toComponent() = Component.literal(this)

}
