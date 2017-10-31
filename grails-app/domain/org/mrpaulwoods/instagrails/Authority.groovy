package org.mrpaulwoods.instagrails

class Authority {

	static belongsTo = [ user: User ]

	Date dateCreated
	Date lastUpdated

    static constraints = {
    }
    
}
