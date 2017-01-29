package oauth.client

import groovy.json.JsonSlurper
import groovy.transform.CompileStatic
import org.pac4j.oauth.profile.OAuth20Profile

@CompileStatic
class GrailsOAuthProfile extends OAuth20Profile {
	@SuppressWarnings("GroovyUnusedDeclaration")
	private static final long serialVersionUID = 1L

	GrailsOAuthProfile() {
	}

	GrailsOAuthProfile(String requestBody) {
		final json = new JsonSlurper().parseText(requestBody)
		setId(json['id'] as String)
		addAttribute("username", json['username'])
		addAttribute("email", json['username'])
		addAttribute("enabled", json['enabled'])
		addAttribute("accountExpired", Boolean.getBoolean(json['accountExpired'] as String))
		addAttribute("accountLocked", Boolean.getBoolean(json['accountLocked'] as String))
		addAttribute("passwordExpired", Boolean.getBoolean(json['passwordExpired'] as String))
		final roles = json['roles'] as Collection<String>
		roles.each { role -> addRole(role) }
	}
}