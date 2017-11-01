package org.mrpaulwoods.instagrails

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Image {

	static belongsTo = [ user: User, post: Post ]

	byte[] content
	String name
	String contentType
	ImageType imageType
	Date dateCreated
	Date lastUpdated

	static constraints = {
    	content maxSize: 4194304
    	name maxSize: 300
    	contentType maxSize: 200
    	imageType maxSize: 50
    }
    
}
