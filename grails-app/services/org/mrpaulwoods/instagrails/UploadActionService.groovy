package org.mrpaulwoods.instagrails

class UploadActionService {
	
	def postService
	def imageService
	def thumbnailService

	Post execute(
		String filename,
		String contentType,
		byte[] content,
		String text,
		User user
	) {

		log.debug "uploadActionService {} {} {} {} {}", filename, contentType, content.size(), text, user

		Post post = new Post(
			text: text,
			user: user
		)
		assert post.save()

		Image image = new Image(
			name: filename,
			contentType: contentType,
			content: content,
			imageType: ImageType.ORIGINAL,
			user: user
		)
		post.addToImages image

		assert post.save(flush: true)

		thumbnailService.execute post, image

		post
	}
	
}

