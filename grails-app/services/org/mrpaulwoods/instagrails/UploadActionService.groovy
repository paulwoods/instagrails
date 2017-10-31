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

		Post post = new Post(
			text: text,
			user: user
		)
		post.save()
		assert post

		Image image = new Image(
			name: filename,
			contentType: contentType,
			content: content,
			imageType: ImageType.ORIGINAL,
			user: user
		)
		post.addToImages image
		assert post.save()

		thumbnailService.execute post, image

		post
	}
	
}

