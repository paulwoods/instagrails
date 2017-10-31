package org.mrpaulwoods.instagrails

class Post {

	static belongsTo = [ user: User ]
	static hasMany = [ images: Image, comments: Comment ]

	String text
	Date dateCreated
	Date lastUpdated

	static mapping = {
		comments sort: 'dateCreated', order: 'desc'
	}

	static constraints = {
    	text maxLength: 2000
    }

}
