package gay.j10a1n15.customscoreboard.config.position

import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardOverlay
import gay.j10a1n15.customscoreboard.utils.Text.toComponent
import net.minecraft.client.gui.screens.ChatScreen
import net.minecraft.client.gui.screens.Screen
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.render.RenderHudEvent
import tech.thatgravyboat.skyblockapi.api.events.screen.ScreenMouseClickEvent
import tech.thatgravyboat.skyblockapi.api.location.LocationAPI
import tech.thatgravyboat.skyblockapi.helpers.McClient
import tech.thatgravyboat.skyblockapi.helpers.McScreen

object Overlays {

    private val overlays = mutableListOf<Overlay>()

    fun register(overlay: Overlay) {
        overlays.add(overlay)
    }

    private fun isOverlayScreen(screen: Screen?): Boolean {
        return screen is ChatScreen
    }

    @Subscription
    fun onHudRender(event: RenderHudEvent) {
        if (!LocationAPI.isOnSkyblock) return

        val graphics = event.graphics
        val screen = McScreen.self
        val (mouseX, mouseY) = McClient.mouse
        overlays.forEach {
            if (!it.enabled) return@forEach
            val (x, y) = it.position

            graphics.pose().pushPose()
            graphics.pose().translate(x.toFloat(), y.toFloat(), 0f)
            graphics.pose().scale(it.position.scale, it.position.scale, 1f)
            it.render(graphics, mouseX.toInt(), mouseY.toInt())
            graphics.pose().popPose()

            val rect = it.editBounds * it.position.scale

            if (isOverlayScreen(screen) && rect.contains(mouseX.toInt(), mouseY.toInt())) {
                graphics.fill(rect.x, rect.y, rect.right, rect.bottom, 0x50000000)
                graphics.renderOutline(rect.x - 1, rect.y - 1, rect.width + 2, rect.height + 2, 0xFFFFFFFF.toInt())
                if (it.moveable) {
                    screen!!.setTooltipForNextRenderPass("Click to edit".toComponent())
                } else {
                    screen!!.setTooltipForNextRenderPass(it.name)
                }
            }
        }
    }

    @Subscription
    fun onMouseClick(event: ScreenMouseClickEvent.Pre) {
        if (!LocationAPI.isOnSkyblock) return
        if (!isOverlayScreen(event.screen)) return

        for (overlay in overlays.reversed()) {
            if (!overlay.enabled) continue
            if (!overlay.moveable) continue
            val rect = overlay.editBounds * overlay.position.scale

            if (rect.contains(event.x, event.y)) {
                McClient.self.setScreen(OverlayScreen(overlay))
                return
            }
        }
    }

    init {
        register(ScoreboardOverlay)
    }
}
