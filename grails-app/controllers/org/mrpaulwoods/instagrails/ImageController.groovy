package org.mrpaulwoods.instagrails

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_USER")
class ImageController {

    def thumbnail(Post post) {
    	Image image = Image.findByPostAndImageType(post, ImageType.THUMBNAIL)
    	response.contentType = image.contentType
    	response.outputStream << image.content
    }

    def original(Post post) {
    	Image image = Image.findByPostAndImageType(post, ImageType.ORIGINAL)
    	response.contentType = image.contentType
    	response.outputStream << image.content
    }

}
