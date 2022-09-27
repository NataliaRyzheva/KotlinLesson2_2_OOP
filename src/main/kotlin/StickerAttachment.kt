data class StickerAttachment(val audio: Sticker) : Attachment {
    override val type = "sticker"
}