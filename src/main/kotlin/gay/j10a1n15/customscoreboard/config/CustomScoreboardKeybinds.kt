package gay.j10a1n15.customscoreboard.config

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.KeyMapping
import org.lwjgl.glfw.GLFW

object CustomScoreboardKeybinds {
    val TOGGLE_KEY: KeyMapping = KeyBindingHelper.registerKeyBinding(
        KeyMapping(
            "config.cs.keybind.toggle",
            GLFW.GLFW_KEY_I,
            "config.cs",
        ),
    )
}
