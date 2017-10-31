package org.mrpaulwoods.instagrails

class PostController {

    def show(Post post) { 
    	[post: post]
    }

}
