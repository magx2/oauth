package oauth.client

import groovy.transform.CompileStatic
import org.pac4j.core.context.WebContext
import org.pac4j.oauth.client.BaseOAuth20Client
import org.scribe.model.Token

@CompileStatic
class GrailsOAuthClient extends BaseOAuth20Client<GrailsOAuthProfile> {
	@SuppressWarnings("GroovyUnusedDeclaration")
	private static final long serialVersionUID = 1L

	GrailsOAuthClient(String key, String secret) {
		setKey(key)
		setSecret(secret)
	}

	@Override
	void internalInit(final WebContext context) {
		super.internalInit(context)
		this.service = new GrailsOAuthServiceImpl(new GrailsOAuthApi(), new GrailsOAuthConfig(getKey(), getSecret()))
	}

	@Override
	protected boolean hasBeenCancelled(WebContext context) {
		false
	}

	@Override
	protected String getProfileUrl(Token accessToken) {
		"http://localhost:9000/api/me"
	}

	@Override
	protected GrailsOAuthProfile extractUserProfile(String body) {
		new GrailsOAuthProfile(body)
	}

	@Override
	protected GrailsOAuthClient newClient() {
		new GrailsOAuthClient(getKey(), getSecret())
	}
}