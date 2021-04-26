package br.dev.rvz.gerenciadorhopital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

    private final String[] PUBLIC_MATCHERS_GET = {
            "/paciente/**",
            "/historico/**",
            "/consulta/**"

    };

    private final String[] PUBLIC_MATCHERS_POST = {
            "/paciente/**",
            "/historico/**",
            "/consulta/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET)
                .permitAll()
                .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST)
                .permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    protected UrlBasedCorsConfigurationSource configuracaoCors() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
