package me.fabricionogueira.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final Integer ACCESS_TOKEN_VALIDITY_IN_SECONDS = 120 * 24;
	private static final Integer REFRESH_TOKEN_VALIDITY_IN_SECONDS = 120 * 24;

	@Value("${security.oauth2.client.client-id}")
	private String client;

	@Value("${security.oauth2.client.client-secret}")
	private String secret;

	private AuthenticationManager authenticationManager;
	private DefaultTokenServices defaultTokenServices;
	private AccessTokenConverter accessTokenConverter;

	@Autowired
	public AuthorizationServerConfig(
		AuthenticationManager authenticationManager,
		DefaultTokenServices defaultTokenServices,
		AccessTokenConverter accessTokenConverter) {

		this.authenticationManager = authenticationManager;
		this.defaultTokenServices = defaultTokenServices;
		this.accessTokenConverter = accessTokenConverter;
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()")
			.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient(client)
			.secret(new BCryptPasswordEncoder().encode(secret))
			.authorizedGrantTypes("password")
			.scopes("read", "write")
			.resourceIds("oauth2-resource")
			.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_IN_SECONDS)
			.refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_IN_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenServices(defaultTokenServices)
			.authenticationManager(authenticationManager)
			.accessTokenConverter(accessTokenConverter);
	}
}
