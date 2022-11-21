package io.no767.himeko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HimekoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HimekoApplication.class, args);
//        Client client = context.getBean(Client.class);
//        client.get().block();
    }

}
