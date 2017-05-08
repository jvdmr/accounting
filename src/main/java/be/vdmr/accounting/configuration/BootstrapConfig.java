package be.vdmr.accounting.configuration;

import be.vdmr.accounting.model.User;
import be.vdmr.accounting.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.annotation.Resource;

@Configuration
public class BootstrapConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDatabase();
    }

    private void initDatabase() {
        if (userRepository.findAll().isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(BCrypt.hashpw("admin", BCrypt.gensalt()));
            userRepository.save(admin);
        }
    }
}
