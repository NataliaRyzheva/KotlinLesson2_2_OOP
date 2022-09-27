data class PhotoAttachment(val photo: Photo) : Attachment {
    override val type = "photo"
}