package gay.j10a1n15.customscoreboard.feature.updatechecker

import gay.j10a1n15.customscoreboard.Main
import gay.j10a1n15.customscoreboard.config.MainConfig
import gay.j10a1n15.customscoreboard.utils.ChatUtils
import kotlinx.coroutines.runBlocking
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents
import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.minecraft.client.Minecraft
import net.minecraft.client.multiplayer.ClientPacketListener
import tech.thatgravyboat.skyblockapi.utils.http.Http

const val SLUG = "skyblock-custom-scoreboard"
const val URL = "https://api.modrinth.com/v2/project/$SLUG/version"
const val LOADER = "fabric"
const val GAME_VERSION = "1.21.1"
const val QUERIES = "?loaders=%5B%22$LOADER%22%5D&game_versions=%5B%22$GAME_VERSION%22%5D"

object UpdateChecker {

    var isOutdated = false
        private set

    private var latest: ModrinthJson? = null

    init {
        runBlocking {
            check()
        }

        ClientPlayConnectionEvents.JOIN.register(::onServerJoin)
    }

    @JvmStatic
    private suspend fun check() {
        val url = "$URL$QUERIES"

        val response = Http.getResult<List<ModrinthJson>>(
            url = url,
            errorFactory = ::RuntimeException,
        ).getOrNull() ?: return

        latest = response.maxByOrNull { it.version_number } ?: return

        isOutdated = latest?.let { it.version_number > Main.VERSION } == true
    }

    fun onServerJoin(handler: ClientPacketListener, sender: PacketSender, client: Minecraft) {
        if (MainConfig.updateNotification && isOutdated) {
            ChatUtils.link(
                "§eA new version of Custom Scoreboard is available! §7(§e${Main.VERSION}§7 -> §e${latest?.version_number}§7). §eClick here to open Modrinth!",
                "https://modrinth.com/mod/skyblock-custom-scoreboard",
            )
        }
    }

}
