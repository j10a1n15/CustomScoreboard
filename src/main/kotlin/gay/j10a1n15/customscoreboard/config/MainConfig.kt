package gay.j10a1n15.customscoreboard.config;

import com.teamresourceful.resourcefulconfig.api.annotations.*
import com.teamresourceful.resourcefulconfig.api.types.options.EntryType
import gay.j10a1n15.customscoreboard.config.objects.TitleOrFooterObject
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardEntry

@ConfigInfo.Provider(InfoProvider::class)
@Config(
    value = "customscoreboard/config",
    categories = [],
)
object MainConfig {

    @ConfigEntry(
        id = "Appearance",
        type = EntryType.ENUM,
    )
    @ConfigOption.Draggable
    @Comment("Edit this list to change the order of appearance of the scoreboard.")
    var appearance: Array<ScoreboardEntry> = ScoreboardEntry.entries.toTypedArray()

    @ConfigEntry(
        id = "Title Options",
        type = EntryType.OBJECT,
    )
    @Comment("Edit the title of the scoreboard.")
    val title: TitleOrFooterObject = TitleOrFooterObject()

    @ConfigEntry(
        id = "Footer Options",
        type = EntryType.OBJECT,
    )
    @Comment("Edit the footer of the scoreboard.")
    val footer: TitleOrFooterObject = TitleOrFooterObject()
}
