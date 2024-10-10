package gay.j10a1n15.customscoreboard.config.categories

import com.teamresourceful.resourcefulconfig.api.annotations.Category
import com.teamresourceful.resourcefulconfig.api.annotations.Comment
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigOption

@Category("Background")
object BackgroundConfig {

    @ConfigEntry(id = "enabled", translation = "config.cs.background.enabled")
    @Comment("", translation = "config.cs.background.enabled.desc")
    var enabled: Boolean = true

    @ConfigEntry(id = "color", translation = "config.cs.background.color")
    @Comment("", translation = "config.cs.background.color.desc")
    @ConfigOption.Color(alpha = true)
    var color: Int = 0x80000000.toInt()

    @ConfigEntry(id = "padding", translation = "config.cs.background.padding")
    @Comment("", translation = "config.cs.background.padding.desc")
    @ConfigOption.Range(min = 0.0, max = 20.0)
    @ConfigOption.Slider
    var padding: Int = 5

}
