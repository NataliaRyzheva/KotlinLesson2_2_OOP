import org.jetbrains.annotations.Nullable
import java.time.LocalDate


data class Post(
    val id: Int = 0,                      //Идентификатор записи
    val fromId: Int = 0,                  //Идентификатор автора записи (от чьего имени опубликована запись)
    val createdBy: Int = 0,               //Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад
    val replyOwnerId: Int = 0,            //Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean = true,      //1, если запись была создана с опцией «Только для друзей»
    val date: LocalDate = LocalDate.now(),//Время публикации записи в формате unixtime
    val text: String = "Hello world",     //Текст записи
    val isFavorite: Boolean = true,       //true, если объект добавлен в закладки у текущего пользователя
    val ownerId: Int = 0,
    val postType: String = "_",
    val signerId: Int = 0,
    val canPin: Int = 0,
    val canDelete: Int = 0,
    val canEdit: Int = 0,
    val isPinned: Int = 0,
    val markedAsAds: Int = 0,
    val postponedId: Int = 0,
    val comments: Comments? = Comments(),
    val likes: Likes = Likes(),
    var attachments: Array<Attachment> = emptyArray()


)

data class Comments(
    val count: Int = 0,                  //количество комментариев
    val canPost: Boolean = true,         //информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может)
    val groupsCanPost: Boolean = true,   //информация о том, могут ли сообщества комментировать запись
    val canClose: Boolean = true,        //может ли текущий пользователь закрыть комментарии к записи
    val canOpen: Boolean = true          //может ли текущий пользователь открыть комментарии к записи
)

data class Likes(
    val count: Int = 0,                 //число пользователей, которым понравилась запись
    val userLikes: Boolean = true,      //наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет)
    val canLike: Boolean = true,        //информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может)
    val canPublish: Boolean = true      //информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может)
)