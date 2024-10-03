package gay.j10a1n15.customscoreboard.config

import com.teamresourceful.resourcefulconfig.api.client.ResourcefulConfigScreen
import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import gay.j10a1n15.customscoreboard.Main
import net.minecraft.client.gui.screens.Screen

class ModMenuCompat : ModMenuApi {

    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory { t: Screen? ->
            ResourcefulConfigScreen.get(
                t,
                Main.configurator,
                MainConfig::class.java
            )
        }
    }
}