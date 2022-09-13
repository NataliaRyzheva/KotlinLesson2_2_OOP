class WallService {
    private var posts = emptyArray<Post>()



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
