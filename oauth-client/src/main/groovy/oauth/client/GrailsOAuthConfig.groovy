package oauth.client

import org.scribe.model.OAuthConfig
import org.scribe.model.SignatureType

class GrailsOAuthConfig extends OAuthConfig {
	GrailsOAuthConfig(String key, String secret) {
		super(key, secret, "http://localhost:8080/oauth/callback/grailsoauth", null, "read", null)
	}
}