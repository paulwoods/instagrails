package org.mrpaulwoods.instagrails

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Comment {

	static belongsTo = [ user: User, post: Post ]

	String text
	Date dateCreated
	Date lastUpdated

	static constraints = {
    	text maxSize: 500
    }

}
