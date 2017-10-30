package org.mrpaulwoods.instagrails

class Comment {

	static belongsTo = [ user: User, post: Post ]

	String text
	Date dateCreated
	Date lastUpdated

    static constraints = {
    	text maxSize: 2000
    }

}
