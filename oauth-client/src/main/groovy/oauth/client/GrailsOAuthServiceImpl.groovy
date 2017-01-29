
package oauth.client

import org.scribe.builder.api.DefaultApi20
import org.scribe.model.OAuthConfig
import org.scribe.model.OAuthConstants
import org.scribe.model.OAuthRequest
import org.scribe.model.Response
import org.scribe.model.Token
import org.scribe.model.Verifier
import org.scribe.oauth.OAuth20ServiceImpl

class GrailsOAuthServiceImpl extends OAuth20ServiceImpl {
	private final DefaultApi20 api
	private final GrailsOAuthConfig config

	GrailsOAuthServiceImpl(DefaultApi20 api, GrailsOAuthConfig config) {
		super(api, config)
		this.api = api
		this.config = config
	}

	Token getAccessToken(Token requestToken, Verifier verifier) {
		OAuthRequest request = new OAuthRequest(api.getAccessTokenVerb(), api.getAccessTokenEndpoint())
		request.addQuerystringParameter(OAuthConstants.CLIENT_ID, config.getApiKey())
		request.addQuerystringParameter(OAuthConstants.CLIENT_SECRET, config.getApiSecret())
		request.addQuerystringParameter(OAuthConstants.CODE, verifier.getValue())
		request.addQuerystringParameter(OAuthConstants.REDIRECT_URI, config.getCallback())
		request.addQuerystringParameter("grant_type", "authorization_code") // This line is not added to request params in OAuth20ServiceImpl
		if (config.hasScope()) request.addQuerystringParameter(OAuthConstants.SCOPE, config.getScope())
		Response response = request.send()
		return api.getAccessTokenExtractor().extract(response.getBody())
	}
}