package org.mrpaulwoods.instagrails

import grails.validation.Validateable

class CommentController {

    def add(CommentCommand cmd) {
    	if(cmd.hasErrors()) {

    		if(cmd.post) {
    			redirect controller:"post", action:"show", id:cmd.post.id
    		} else {
    			redirect controller:"home", action:"index"
    		}

    		return
    	}

    	Comment comment = new Comment(
    		post: cmd.post,
    		text: cmd.comment,
    		user: User.get(1) // TODO: 
    	)

    	assert comment.save()

    	redirect controller:"post", action:"show", id:cmd.post.id 
    }

} 

class CommentCommand implements Validateable  {

	Post post
	String comment

	static constraints = {
		post nullable: false
		comment nullable: false, minSize: 1, maxSize: 500
	}

}
