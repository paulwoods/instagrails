package org.mrpaulwoods.instagrails

class User {

	static hasMany = [ 
		authorities: Authority, 
		posts: Post, 
		comments: Comment,
		images: Image
	]

	String username
	String password
	Date dateCreated
	Date lastUpdated

	static constraints = {
    }

}
