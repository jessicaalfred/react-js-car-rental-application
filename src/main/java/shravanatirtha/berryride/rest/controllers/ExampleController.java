package shravanatirtha.berryride.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * The Class ExampleController.
 */
@RestController
public class ExampleController {
    
    /**
     * Hello.
     *
     * @return the string
     */
    @RequestMapping("")
    public String hello() {
        return "Hello, the time at the server is now " + new Date() + "\n";
    }
}
