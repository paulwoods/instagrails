package org.mrpaulwoods.instagrails

class HomeController {

    def index() { 
    	def posts = Post.list( max: 10, sort: "lastUpdated", order: "desc")
    	[ posts: posts ] 
    }

}
