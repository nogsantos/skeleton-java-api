package me.fabricionogueira.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	static final String CLIEN_ID = "devglan-client";
	static final String CLIENT_SECRET = "$2a$04$e/c1/RfsWuThaWFCrcCuJeoyvwCV0URN/6Pn9ZFlrtIWaU/vj/BfG";
	static final String GRANT_TYPE = "password";
	static final String AUTHORIZATION_CODE = "authorization_code";
	static final String REFRESH_TOKEN = "refresh_token";
	static final String IMPLICIT = "implicit";
	static final String SCOPE_READ = "read";
	static final String SCOPE_WRITE = "write";
	static final String TRUST = "trust";

	private static final Integer ACCESS_TOKEN_VALIDITY_IN_SECONDS = 60 * 60 * 24;
	private static final Integer REFRESH_TOKEN_VALIDITY_IN_SECONDS = 60 * 60 * 24;

	@Value("${security.oauth2.client.client-id}")
	private String client;

	@Value("${security.oauth2.client.client-secret}")
	private String secret;

	private AuthenticationManager authenticationManager;

	private TokenStore tokenStore;

	@Autowired
	public AuthorizationServerConfig(AuthenticationManager authenticationManager, TokenStore tokenStore) {
		this.authenticationManager = authenticationManager;
		this.tokenStore = tokenStore;
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()")
			.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		configurer
			.inMemory()
			.withClient(CLIEN_ID)
			.secret(CLIENT_SECRET)
			.authorizedGrantTypes(GRANT_TYPE, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
			.scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
			.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_IN_SECONDS).
			refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_IN_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore)
			.authenticationManager(authenticationManager);
	}
}
