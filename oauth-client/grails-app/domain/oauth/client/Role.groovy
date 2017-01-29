package oauth.client

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.security.core.GrantedAuthority

@EqualsAndHashCode(includes = 'authority')
@ToString(includes = 'authority', includeNames = true, includePackage = false)
class Role implements Serializable, GrantedAuthority {
	@SuppressWarnings("GroovyUnusedDeclaration")
	private static final long serialVersionUID = 1

	String authority

	static constraints = {
		authority unique: true, nullable: false, blank: false
	}
}