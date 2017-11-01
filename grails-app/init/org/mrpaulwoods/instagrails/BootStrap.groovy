package org.mrpaulwoods.instagrails

import org.springframework.core.io.ClassPathResource

class BootStrap {

	def securityService
	def uploadActionService

	def init = { servletContext ->

		User user = new User(
			username: "mr.paul.woods@gmail.com",
    		password: "123456")
		assert user.save(flush: true)

		Authority authority = new Authority(
			authority: "ROLE_USER")
		assert authority.save(flush: true)

		UserAuthority.create user, authority



		Post post1 = uploadActionService.execute(
			"all code is guilty until proven innocent",
			"image/png",
			new ClassPathResource("01.png").inputStream.bytes,
			"anonymous quote",
			user
		)
		assert post1

		sleep 1

		Post post2 = uploadActionService.execute(
			"hello world",
			"image/png",
			new ClassPathResource("02.png").inputStream.bytes,
			"hello world",
			user
		)
		assert post2

		sleep 1

		Post post3 = uploadActionService.execute(
			"maiden voyage",
			"image/jpg",
			new ClassPathResource("03.jpg").inputStream.bytes,
			"maiden voyage",
			user
		)
		assert post3

		sleep 1

		Post post4 = uploadActionService.execute(
			"too busy to improve",
			"image/png",
			new ClassPathResource("04.png").inputStream.bytes,
			"too busy to improve",
			user
		)
		assert post4

		sleep 1

		Post post5 = uploadActionService.execute(
			"compiling",
			"image/png",
			new ClassPathResource("05.png").inputStream.bytes,
			"compiling",
			user
		)
		assert post5

		sleep 1

		Post post6 = uploadActionService.execute(
			"obama",
			"image/jpg",
			new ClassPathResource("06.jpg").inputStream.bytes,
			"obama",
			user
		)
		assert post6

		sleep 1

		def comment1 = new Comment(
			post: post1,
			text: "Leverage agile frameworks to provide a robust synopsis for high level overviews. Iterative approaches to corporate strategy foster collaborative thinking to further the overall value proposition. Organically grow the holistic world view of disruptive innovation via workplace diversity and empowerment.",
			user: user
		)
		assert comment1.save()

		sleep 1

		def comment2 = new Comment(
			post: post1,
			text: "Bring to the table win-win survival strategies to ensure proactive domination. At the end of the day, going forward, a new normal that has evolved from generation X is on the runway heading towards a streamlined cloud solution. User generated content in real-time will have multiple touchpoints for offshoring.",
			user: user
		)
		assert comment2.save()

		sleep 1

		def comment3 = new Comment(
			post: post1,
			text: "Capitalize on low hanging fruit to identify a ballpark value added activity to beta test. Override the digital divide with additional clickthroughs from DevOps. Nanotechnology immersion along the information highway will close the loop on focusing solely on the bottom line.",
			user: user
		)
		assert comment3.save()
	}

	def destroy = {
	}
	
}
