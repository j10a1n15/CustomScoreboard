package gay.j10a1n15.customscoreboard.config.objects

import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigObject
import com.teamresourceful.resourcefulconfig.api.types.options.EntryType
import gay.j10a1n15.customscoreboard.utils.rendering.Alignment

@ConfigObject
data class TitleOrFooterObject(
    @ConfigEntry(
        id = "Alignment",
        type = EntryType.ENUM,
    )
    var alignment: Alignment = Alignment.CENTER,

    @ConfigEntry(
        id = "Use Custom Text",
        type = EntryType.BOOLEAN,
    )
    var useCustomText: Boolean = false,

    @ConfigEntry(
        id = "Custom Text",
        type = EntryType.STRING,
    )
    var text: String = "",
)
