package uz.farrukh.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"uz.farrukh.library", "uz.farrukh.admin"})
@EnableJpaRepositories(basePackages = "uz.farrukh.library.repositories")
@EntityScan(basePackages = "uz.farrukh.library.entities")
public class AdminControlPanelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminControlPanelApplication.class, args);
    }

}

