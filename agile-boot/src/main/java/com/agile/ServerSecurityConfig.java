package com.agile;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@ImportResource("security-context.xml")
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	@Qualifier("userAuthenticationService")
//	UserDetailsService userDetailsService;
 
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) 
//      throws Exception {
//        auth
////        .userDetailsService(userDetailsService);
//        .inMemoryAuthentication()
//          .withUser("john").password("123").roles("ADMIN");
//    }
// 
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() 
//      throws Exception {
//        return super.authenticationManagerBean();
//    }
// 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	http.csrf().disable();
//        http.authorizeRequests()
//            .antMatchers("/login").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll();
//    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/app");
	}

}
