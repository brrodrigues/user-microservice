package rio.brunorodrigues.usermicroservice;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("SAY-HELLO-MICROSERVICE")
public interface SayHelloMicroservice {

    @GetMapping("/{name}")

    String sayHello(@PathVariable("name") String name);

}
