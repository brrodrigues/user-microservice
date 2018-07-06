package rio.brunorodrigues.usermicroservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rio.brunorodrigues.usermicroservice.SayHelloMicroservice;

@RestController
public class UserController {

    @Autowired
    SayHelloMicroservice sayHelloMicroservice;

    @GetMapping("/{name}")
    @HystrixCommand( fallbackMethod = "getNameFallback" )
    public String getName(@PathVariable String name){

        String hello = sayHelloMicroservice.sayHello(name);

        return hello;
    }

    //***Atencao - A assinatura do metodo tem que ser igual a assinatura da chamada.
    //public String getName(String name){
    public String getNameFallback(String erro) {
        return "Nao foi possivel ao servico Hello. Tentei mais tarde";
    }
}
