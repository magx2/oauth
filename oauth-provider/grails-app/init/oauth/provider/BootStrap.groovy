package oauth.provider

class BootStrap {

	def init = { servletContext ->
		final user = new User(username: 'magx2', password: 'xxx').save(failOnError: true)
		final role = new Role("ROLE_USER").save(failOnError: true)
		new UserRole(user, role).save()

		new Client(
				clientId: 'client-key',
				clientSecret: 'client-secret',
				authorizedGrantTypes: ['authorization_code', 'refresh_token'],
				authorities: ['ROLE_CLIENT'],
				scopes: ['read', 'write'],
				redirectUris: ['http://localhost:8080/oauth/callback/oauthProvider']
		).save(flush: true, failOnError: true)
	}
	def destroy = {
	}
}
