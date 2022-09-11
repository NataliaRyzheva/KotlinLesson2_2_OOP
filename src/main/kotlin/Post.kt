import org.jetbrains.annotations.Nullable
import java.time.LocalDate


data class Post(
    val id: Int = 0,                     //Идентификатор записи
    val from_id: Int = 0,                //Идентификатор автора записи (от чьего имени опубликована запись)
    val created_by: Int = 0,             //Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад
    val reply_owner_id: Int = 0,         //Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val friends_only: Boolean = true,    //1, если запись была создана с опцией «Только для друзей»
    val date: LocalDate = LocalDate.now(),   //Время публикации записи в формате unixtime
    val text: String = "Hello world",    //Текст записи
    val is_favorite: Boolean = true, //true, если объект добавлен в закладки у текущего пользователя
    val owner_id: Int = 0,
    val post_type: String = "_",
    val signer_id: Int = 0,
    val can_pin: Int = 0,
    val can_delete: Int = 0,
    val can_edit: Int = 0,
    val is_pinned: Int = 0,
    val marked_as_ads: Int = 0,
    val postponed_id: Int = 0,
    val comments: Comments? = Comments(),
    val likes: Likes = Likes(),
    var attachments: Array<Attachment> = emptyArray()


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