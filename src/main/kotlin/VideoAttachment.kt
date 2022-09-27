data class VideoAttachment(val video: Video) : Attachment {
    override val type = "video"
}