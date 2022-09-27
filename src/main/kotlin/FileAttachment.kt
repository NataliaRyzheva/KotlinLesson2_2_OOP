data class FileAttachment(val file: File) : Attachment {
    override val type = "file"
}