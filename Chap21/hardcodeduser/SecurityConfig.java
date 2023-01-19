package chap21.security.hardcodeduser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("prof")
                .password("{noop}prof") // noop = non chiffré
                .authorities("PROF") //
                .and()
                .withUser("etudiant")
                .password("{noop}etudiant")
                .authorities("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/private").authenticated() // Nécessite d'être identifié
                .antMatchers("/**").permitAll() // Toutes les autres sont publiques
                .and()
                .formLogin() // Identification via la page de login par défaut
        ;
    }
}
