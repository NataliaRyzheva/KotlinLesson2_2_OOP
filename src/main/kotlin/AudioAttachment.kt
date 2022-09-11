data class AudioAttachment(val audio: Audio) : Attachment {
    override val type = "audio"
}