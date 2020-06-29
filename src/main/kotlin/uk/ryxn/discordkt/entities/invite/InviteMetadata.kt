package uk.ryxn.discordkt.entities.invite

import com.google.gson.annotations.SerializedName
import java.time.OffsetDateTime

class InviteMetadata(
    @SerializedName("uses")
    val uses: Int,

    @SerializedName("max_uses")
    val maxUses: Int,

    @SerializedName("max_age")
    val maxAge: Int, // seconds

    @SerializedName("temporary")
    val temporary: Boolean,

    @SerializedName("created_at")
    val createdAt: OffsetDateTime
) : Invite()