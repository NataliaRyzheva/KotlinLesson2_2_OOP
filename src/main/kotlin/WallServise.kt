class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()
   // var lastId = 0

    fun createComment(postId: Int, comment: Comments): Comments {
        for (post in posts) {
            if (postId == post.id) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("Post not found")

    }

    fun add(post: Post): Post {
        posts += post.copy(id = post.id)
        return posts.last()
    }


    fun update(postId: Post): Boolean {
        for ((index, post) in posts.withIndex())
            if (post.id == postId.id) {
                posts[index] = post.copy(
                    id = post.id,
                    ownerId = post.ownerId,
                    date = post.date

                )
                return true
            }
        return false
    }


    }



