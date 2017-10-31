package org.mrpaulwoods.instagrails

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
