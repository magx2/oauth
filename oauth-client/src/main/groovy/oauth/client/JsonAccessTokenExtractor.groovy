package oauth.client

import groovy.json.JsonSlurper
import groovy.transform.CompileStatic
import org.scribe.exceptions.OAuthException
import org.scribe.extractors.AccessTokenExtractor
import org.scribe.model.Token

@CompileStatic
class JsonAccessTokenExtractor implements AccessTokenExtractor {
	@Override
	Token extract(String response) throws OAuthException {
		final json = new JsonSlurper().parseText(response)
		final accessToken = json["access_token"] as String
		if (accessToken) {
			return new Token(accessToken, response)
		} else {
			throw new OAuthException("Cannot extract an access token. Response was: " + response)
		}
	}
}
