package gay.j10a1n15.customscoreboard.feature.customscoreboard.elements

import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.location.ServerChangeEvent
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ElementLobby : Element() {
    private val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    private var lobbyCode: String? = null

    override fun getDisplay() = "§7" + LocalDate.now().format(formatter) + " §8$lobbyCode"

    override val configLine = "Lobby"

    @Subscription
    fun onServerChange(event: ServerChangeEvent) {
        lobbyCode = event.name.replace("mini", "m").replace("mega", "M")
    }
}
