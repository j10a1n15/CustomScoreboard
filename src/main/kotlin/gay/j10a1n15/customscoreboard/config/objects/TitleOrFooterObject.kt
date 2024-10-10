package gay.j10a1n15.customscoreboard.config.objects

import com.teamresourceful.resourcefulconfig.api.annotations.Comment
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigObject
import gay.j10a1n15.customscoreboard.utils.rendering.alignment.TextAlignment

@ConfigObject
data class TitleOrFooterObject(
    @ConfigEntry(id = "alignment", translation = "config.cs.title_footer.alignment")
    @Comment("", translation = "config.cs.title_footer.alignment.desc")
    var alignment: TextAlignment = TextAlignment.CENTER,

    @ConfigEntry(id = "use_custom_text", translation = "config.cs.title_footer.use_custom_text")
    @Comment("", translation = "config.cs.title_footer.use_custom_text.desc")
    var useCustomText: Boolean = false,

    @ConfigEntry(id = "custom_text", translation = "config.cs.title_footer.custom_text")
    @Comment("", translation = "config.cs.title_footer.custom_text.desc")
    var text: String = "",
)
