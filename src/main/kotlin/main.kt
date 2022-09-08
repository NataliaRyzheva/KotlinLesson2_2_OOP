import java.time.LocalDate
import java.util.Objects

data class Post(
    val id: Int = 0,                     //Идентификатор записи
    val from_id: Int = 0,                //Идентификатор автора записи (от чьего имени опубликована запись)
    val created_by: Int = 0,             //Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад
    val reply_owner_id: Int = 0,         //Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val friends_only: Boolean = true,    //1, если запись была создана с опцией «Только для друзей»
    val date: LocalDate = LocalDate.now(),   //Время публикации записи в формате unixtime
    val text: String = "Hello world",    //Текст записи
    val is_favorite: Boolean = true,     //true, если объект добавлен в закладки у текущего пользователя
    val comments: Comments = Comments(),
    val likes: Likes = Likes()
)

data class Comments(
    val count: Int = 0,                  //количество комментариев
    val can_post: Boolean = true,        //информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может)
    val groups_can_post: Boolean = true, //информация о том, могут ли сообщества комментировать запись
    val can_close: Boolean = true,       //может ли текущий пользователь закрыть комментарии к записи
    val can_open: Boolean = true        //может ли текущий пользователь открыть комментарии к записи
)

data class Likes(
    val count: Int = 0,                 //число пользователей, которым понравилась запись
    val userLikes: Boolean = true,      //наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет)
    val canLike: Boolean = true,        //информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может)
    val canPublish: Boolean = true      //информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может)
)

class WallService {
    private var posts = emptyArray<Post>()


    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(postId: Post): Boolean {
        for ((index, post) in posts.withIndex())
            if (post.id == postId.id) {
                posts[index] = post.copy(
                    id = post.id
                )
                return true
            }
        return false
    }
}

fun main() {
    val wallService = WallService()

    val post1 = wallService.add(Post(1, 876, 987, 876, false))
    val post2 = wallService.add(Post(2, 765, 34))
    val post3 = wallService.update(Post(1, 888, 777, 555, true))

    println(post1)
    println(post2)
    println(post3)

}