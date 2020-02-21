package waka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import waka.access.User;
import waka.persistence.UserStore;


public class DataImporter implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(DataImporter.class);

    @Autowired
    private UserStore.UserRepository userRepository;

    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent (ContextRefreshedEvent event) {
        if (log.isInfoEnabled()) {
            log.info("importing data into database...");
        }

        Long usersCount = userRepository.count();
        if (usersCount == 0) {
            if (log.isDebugEnabled()) {
                log.debug("import users data into database...");
            }
            User t1 = new User();
            t1.setName("admin");
//            t1.setPassWord(passwordEncoder.encode("test123"));
            t1.setPassWord("test123");
            t1.setRole("ADMIN");
            userRepository.save(t1);
            User t2 = new User();
            t2.setName("testuser");
            t2.setPassWord("test123");
//            t2.setPassWord(passwordEncoder.encode("test123"));
            t2.setRole("USER");
            userRepository.save(t2);
        }
    }

    // create two users, admin and user
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("ADMIN");
//    }
}

