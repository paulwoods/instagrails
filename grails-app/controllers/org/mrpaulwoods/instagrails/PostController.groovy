package org.mrpaulwoods.instagrails

class PostController {

    def show(Post post) { 
    	[
    		post: post,
    		commentCommand: new CommentCommand(post: post)
    	]
    }

}
