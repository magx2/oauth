package oauth.client

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {
	@SuppressWarnings("GroovyUnusedDeclaration")
	private static final long serialVersionUID = 1

	String username
	Set<Role> roles = []

	static constraints = {
		username unique: true, nullable: false, blank: false
	}
}