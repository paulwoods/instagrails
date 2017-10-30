package org.mrpaulwoods.instagrails

import grails.gorm.transactions.Transactional

@Transactional
class SecurityService {

    User register(String username, String password) {
    
    	User user = User.findByUsername(username) 

    	if(!user) {
    		user = new User(
    			username: username,
    			password: password).save()
    	}

    	user
    }

}
