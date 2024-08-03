package gay.j10a1n15.customscoreboard.config

import com.teamresourceful.resourcefulconfig.api.annotations.Comment
import com.teamresourceful.resourcefulconfig.api.annotations.Config
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigOption.Draggable
import com.teamresourceful.resourcefulconfig.api.types.options.EntryType
import gay.j10a1n15.customscoreboard.feature.customscoreboard.ScoreboardEntry

@ConfigInfo.Provider(InfoProvider::class)
@Config("customscoreboard/config")
object Config {

    @ConfigEntry(
        id = "Appearance",
        type = EntryType.ENUM,
    )
    @Draggable
    @Comment("This is another example config entry.")
    var appearance: Array<ScoreboardEntry> = arrayOf(ScoreboardEntry.TITLE)

}