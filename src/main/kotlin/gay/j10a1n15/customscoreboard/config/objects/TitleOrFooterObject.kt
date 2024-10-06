package gay.j10a1n15.customscoreboard.config.objects

import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigObject
import gay.j10a1n15.customscoreboard.utils.rendering.Alignment

@ConfigObject
data class TitleOrFooterObject(
    @ConfigEntry(id = "alignment")
    var alignment: Alignment = Alignment.CENTER,

    @ConfigEntry(id = "use_custom_text")
    var useCustomText: Boolean = false,

    @ConfigEntry(id = "custom_text")
    var text: String = "",
)
