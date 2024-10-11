package gay.j10a1n15.customscoreboard.config.categories

import com.teamresourceful.resourcefulconfig.api.annotations.Category
import com.teamresourceful.resourcefulconfig.api.annotations.Comment
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry

@Category("Lines")
object LinesConfig {

    @ConfigEntry(id = "bits_available", translation = "config.cs.lines.bits_available")
    @Comment("", translation = "config.cs.lines.bits_available.desc")
    var showBitsAvailable = true

    @ConfigEntry(id = "colored_month", translation = "config.cs.lines.colored_month")
    @Comment("", translation = "config.cs.lines.colored_month.desc")
    var coloredMonth = true

    @ConfigEntry(id = "profile_name", translation = "config.cs.lines.profile_name")
    @Comment("", translation = "config.cs.lines.profile_name.desc")
    var showProfileName = false


}
