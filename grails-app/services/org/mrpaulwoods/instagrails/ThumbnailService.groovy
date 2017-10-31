package org.mrpaulwoods.instagrails

import net.coobird.thumbnailator.Thumbnails

class ThumbnailService {
	
	Image execute(Post post, Image image) {

	    ByteArrayInputStream bais = new ByteArrayInputStream(image.content)
	    ByteArrayOutputStream baos = new ByteArrayOutputStream()

	    Thumbnails
	            .of(bais)
	            .size(120,120)
	            .toOutputStream(baos)

	    Image image2 = new Image(
	            post: image.post,
	            name: image.name,
	            contentType: image.contentType,
	            content: baos.toByteArray(),
	            imageType: ImageType.THUMBNAIL,
	            user: image.user
	    )
	    post.addToImages image2
	    assert post.save()

	    image2
	}

}
