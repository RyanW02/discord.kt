package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName

enum class ChannelType(val clazz: Class<out Channel>) {
    @SerializedName("0")
    GUILD_TEXT(GuildTextChannel::class.java),

    @SerializedName("1")
    DM(DMChannel::class.java),

    @SerializedName("2")
    GUILD_VOICE(GuildVoiceChannel::class.java),

    @SerializedName("3")
    GROUP_DM(GroupDMChannel::class.java),

    @SerializedName("4")
    GUILD_CATEGORY(ChannelCategory::class.java),

    @SerializedName("5")
    GUILD_NEWS(GuildNewsChannel::class.java),

    @SerializedName("6")
    GUILD_STORE(StoreChannel::class.java),
    ;

    companion object {
        fun getById(id: Int) = values()[id]
    }
}