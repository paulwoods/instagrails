package org.mrpaulwoods.instagrails

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_USER")
class HomeController {

    def index() { 
    	def posts = Post.list( max: 10, sort: "lastUpdated", order: "desc")
    	[ posts: posts ] 
    }

}
