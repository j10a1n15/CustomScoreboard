package gay.j10a1n15.customscoreboard.config

import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigColor
import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigColorValue
import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigInfo
import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigLink
import com.teamresourceful.resourcefulconfig.api.types.options.TranslatableValue
import gay.j10a1n15.customscoreboard.Main

class InfoProvider : ResourcefulConfigInfo {
    override fun title(): TranslatableValue = TranslatableValue("Custom Scoreboard Config")

    override fun description(): TranslatableValue = TranslatableValue("by j10a1n15. Version ${Main.VERSION}")

    override fun icon(): String = "box"

    override fun color(): ResourcefulConfigColor = ResourcefulConfigColorValue.create("#808080")

    override fun links(): Array<ResourcefulConfigLink> = arrayOf(
        ResourcefulConfigLink.create(
            "https://github.com/j10a1n15/CustomScoreboard",
            "github",
            TranslatableValue("GitHub")
        )
    )

    override fun isHidden(): Boolean = false
}