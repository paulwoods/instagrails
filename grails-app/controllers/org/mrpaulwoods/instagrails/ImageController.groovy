package org.mrpaulwoods.instagrails

class ImageController {

    def thumbnail(Post post) {
    	Image image = Image.findByPostAndImageType(post, ImageType.ORIGINAL)

    	println "### image = ${image.id} ${image.contentType} ${image.content.size()}"
    	response.contentType = image.contentType
    	response << image.content
    }

}
