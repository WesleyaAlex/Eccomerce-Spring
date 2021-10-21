package eccomerce.spring.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/").permitAll()
        .antMatchers(HttpMethod.GET, "/produto/detalhes-eccomerce/{id}").permitAll()
        .antMatchers(HttpMethod.GET, "/backoffice/produtos").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.GET, "/backoffice/produto/{id}").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.GET, "/backoffice/produto/cadastrar").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.GET, "/backoffice/produto/excluir/{id}").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.GET, "/backoffice/produto/detalhes/{id}").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.GET, "/backoffice/produto/mostrarImagem/{imagem}").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.POST, "/backoffice/produto/salvar").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.GET, "/backoffice/usuarios").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.GET, "/backoffice/usuario/{id}").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.GET, "/backoffice/usuario/cadastrar").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.GET, "/backoffice/usuario/excluir/{id}").hasAnyRole("ADMIN", "ESTOQUISTA")
        .antMatchers(HttpMethod.POST, "/backoffice/usuario/salvar").hasAnyRole("ADMIN", "ESTOQUISTA")
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override
	public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/materialize/**", "/style/**");
    }
}