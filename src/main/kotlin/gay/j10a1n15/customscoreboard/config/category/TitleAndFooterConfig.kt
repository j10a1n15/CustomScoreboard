package gay.j10a1n15.customscoreboard.config.category;

import com.teamresourceful.resourcefulconfig.api.annotations.Category
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.types.options.EntryType
import gay.j10a1n15.customscoreboard.utils.rendering.Alignment

@Category("Title and Footer")
object TitleAndFooterConfig {

    @ConfigEntry(
        id = "Title Alignment",
        type = EntryType.ENUM
    )
    var titleAlignment: Alignment = Alignment.CENTER
}
