package gay.j10a1n15.customscoreboard.config.category;

import com.teamresourceful.resourcefulconfig.api.annotations.Category;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.api.types.options.EntryType;
import gay.j10a1n15.customscoreboard.utils.rendering.Alignment;

@Category("Title and Footer")
public class TitleAndFooterConfig {

    @ConfigEntry(
            id = "Title Alignment",
            type = EntryType.ENUM
    )
    public static Alignment titleAlignment = Alignment.CENTER;
}
