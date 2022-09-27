import java.time.LocalDate

fun main() {
    val wallService = WallService()

    val post1 = wallService.add(Post(1, 876, 987, 876, false, LocalDate.now(),"Hi",true, 0, "_", 8, 5, 7, 2, 8, 9, 4, attachments = arrayOf(AudioAttachment(Audio(1,5)))))
    val post2 = wallService.add(Post(2, 765, 34, 876,false, LocalDate.now(), "_", true, 0, "_", 0, 0, 9, 5, 9, 4, 6, attachments = arrayOf(VideoAttachment(Video(1,5)))))
    val post3 = wallService.update(Post(1, 76, 777, 555, true, LocalDate.now(), "-", false, 5, "_", 4, 3, 6, 8, 4, 3, 3))

    wallService.createComment(2, Comments())

    println(post1)
    println(post2)
    println(post3)

}