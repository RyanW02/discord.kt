package uk.ryxn.discordkt.entities.image

import java.util.*

class ImageData (val type: ImageType, val data: ByteArray) {
    private fun base64() = Base64.getEncoder().encode(data)

    fun encode() = "data:${type.mimeType};base64,${base64()}"
}