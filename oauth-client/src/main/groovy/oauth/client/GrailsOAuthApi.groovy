package oauth.client

import groovy.transform.CompileStatic
import org.scribe.builder.api.DefaultApi20
import org.scribe.extractors.AccessTokenExtractor
import org.scribe.model.OAuthConfig
import org.scribe.model.Verb

@CompileStatic
class GrailsOAuthApi extends DefaultApi20 {
	@Override
	String getAccessTokenEndpoint() {
		"http://localhost:9000/oauth/token"
	}

	@Override
	String getAuthorizationUrl(OAuthConfig config) {
		"http://localhost:9000/oauth/authorize?" +
				"response_type=code&" +
				"client_id=${config.apiKey}&" +
				"client_secret=$config.apiSecret&" +
				"scope=read"
	}

	@Override
	Verb getAccessTokenVerb() {
		Verb.POST
	}

	@Override
	AccessTokenExtractor getAccessTokenExtractor() {
		new JsonAccessTokenExtractor()
	}
}