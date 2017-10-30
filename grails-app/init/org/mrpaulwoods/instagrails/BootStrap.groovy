package org.mrpaulwoods.instagrails

import org.springframework.core.io.ClassPathResource

class BootStrap {

	def securityService
	def uploadActionService

	def init = { servletContext ->

		User user = securityService.register("mr.paul.woods@gmail.com", "11111")

		Post post1 = uploadActionService.execute(
			"all code is guilty until proven innocent",
			"image/png",
			new ClassPathResource("01.png").inputStream.bytes,
			"anonymous quote",
			user
		)
		assert post1

		Post post2 = uploadActionService.execute(
			"hello world",
			"image/png",
			new ClassPathResource("02.png").inputStream.bytes,
			"hello world",
			user
		)
		assert post2

		Post post3 = uploadActionService.execute(
			"maiden voyage",
			"image/jpg",
			new ClassPathResource("03.jpg").inputStream.bytes,
			"maiden voyage",
			user
		)
		assert post3

		Post post4 = uploadActionService.execute(
			"too busy to improve",
			"image/png",
			new ClassPathResource("04.png").inputStream.bytes,
			"too busy to improve",
			user
		)
		assert post4

		Post post5 = uploadActionService.execute(
			"compiling",
			"image/png",
			new ClassPathResource("05.png").inputStream.bytes,
			"compiling",
			user
		)
		assert post5

		Post post6 = uploadActionService.execute(
			"obama",
			"image/jpg",
			new ClassPathResource("06.jpg").inputStream.bytes,
			"obama",
			user
		)
		assert post6

		def comment1 = new Comment(
			post: post1,
			text: "This is the first comment.",
			user: user
		)
		assert comment1.save()

		def comment2 = new Comment(
			post: post2,
			text: "This is the second comment.",
			user: user
		)
		assert comment2.save()

		def comment3 = new Comment(
			post: post3,
			text: "This is the third comment.",
			user: user
		)
		assert comment3.save()
	}

	def destroy = {
	}
	
}
