package rio.brunorodrigues.usermicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class UserMicroserviceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMicroserviceApplication.class);


    public static void main(String[] args) {
        LOGGER.info("************************************************************** env : {}", System.getenv());
        LOGGER.info("************************************************************** properties : {}", System.getProperties());
        SpringApplication.run(UserMicroserviceApplication.class, args);

    }

}
