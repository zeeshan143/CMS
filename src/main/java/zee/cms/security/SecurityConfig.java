//package zee.cms.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	// JDBC Authentication
////	@Autowired
////	@Qualifier("securityDataSource")
////	private DataSource securityDataSource; // We add a reference to our security data source
//	//=====================================================
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// In-memory Authentication
//		UserBuilder users = User.withDefaultPasswordEncoder();		
//		auth.inMemoryAuthentication()
//			.withUser(users.username("admin").password("passadmin").roles("ADMIN", "TEACHER"))
//			.withUser(users.username("teacher").password("passteacher").roles("TEACHER"));
//		//=====================================================================
//		
//		// JDBC Authentication
////		auth.jdbcAuthentication().dataSource(securityDataSource);
//		//=====================================================================
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/").permitAll()
//			.antMatchers("/t/**").hasAnyRole("ADMIN", "TEACHER")
//			.antMatchers("/adm/**").hasRole("ADMIN")
//			.and().httpBasic();
//	}
//}