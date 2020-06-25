package uk.ryxn.discordkt.entities.message

import com.google.gson.annotations.SerializedName

class MessageActivity (
    @SerializedName("type")
    val type: Int,

    @SerializedName("party_id")
    val partyId: String?
)