package org.mrpaulwoods.instagrails

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile
import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_USER")
class PostController {

	def uploadActionService
	def springSecurityService

    def show(Post post) { 
    	[
    		post: post,
    		commentCommand: new CommentCommand(post: post)
    	]
    }

    def create() {
    	[ cmd: new CreatePostCommand() ]
    }

    def save(CreatePostCommand cmd) {

 		User user = springSecurityService.currentUser

 		Post post = uploadActionService.execute(
 			cmd.content.originalFilename,
            cmd.content.contentType,
            cmd.content.bytes,
            cmd.text,
            user)

 		redirect controller:"post", action:"show", id: post.id
    }

}

class CreatePostCommand implements Validateable {

	MultipartFile content
	String text

	static constraints = {

	}
}
