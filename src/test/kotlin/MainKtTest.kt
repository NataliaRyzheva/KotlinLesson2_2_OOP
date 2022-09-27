import org.junit.Test
import org.junit.Assert.*
import java.time.LocalDate

class MainKtTest {

    @Test
    fun addTest() {
        val wallService = WallService()
        val post1 = Post(1, 76, 8765, 8, true, LocalDate.now(), "Hi")

        val result = wallService.add(post = post1)
        assertEquals(1, result.id)

    }

    @Test
    fun updateExisting() {
        val service = WallService()
        service.add(Post(1, 76, 765, 86, true, LocalDate.now(), "Hello world"))
        service.add(Post(2, 746, 865, 36, true, LocalDate.now(), "My friends"))
        val update = Post(1, 788, 87, 876, false, LocalDate.now(), "New text")

        val result = service.update(update)
        assertTrue(result)

    }

    @Test
    fun updateExisting1() {
        val service = WallService()
        service.add(Post(1, 76, 765, 86, true, LocalDate.now(), "Hello world"))
        service.add(Post(2, 746, 865, 36, true, LocalDate.now(), "My friends"))
        val update = Post(3, 788, 87, 876, false, LocalDate.now(), "New text")

        val result = service.update(update)
        assertFalse(result)

    }

    @Test
    fun shouldThrowTrue() {
        val wallService = WallService()
        wallService.add(Post(2))
        val commentTest = Comments()
        wallService.createComment(2, commentTest)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val wallService = WallService()
        wallService.add(Post(3))
        wallService.createComment(postId = 4, Comments())

    }


}