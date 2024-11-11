package gay.j10a1n15.customscoreboard.feature.updatechecker

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ModrinthJson(
    @Expose val name: String,
    @Expose @SerializedName("version_number") val versionNumber: String,
)
