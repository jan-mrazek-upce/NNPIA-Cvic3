package cz.upce.mrazek.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@SpringBootApplication
public class NnpiaSpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(NnpiaSpringbootWebApplication.class, args);
    }

    @Controller
    public class GreetingController {

        private final CounterService counterService;
        private final CounterService superCounterService;

        public GreetingController(@Qualifier("counterServiceImpl") CounterService counterService,
                                  @Qualifier("superCounterServiceImpl") CounterService superCounterService) {
            this.counterService = counterService;
            this.superCounterService = superCounterService;
        }


        @RequestMapping(value = "/welcome/{name}")
        public String requestGreeting(@PathVariable("name") String name, Model model) {
            counterService.add();
            model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
            model.addAttribute("counter", counterService.getCounter());
            return "greeting";
        }

        @RequestMapping(value = "/super/{name}")
        public String listUsersInvoices(@PathVariable("name") String name, Model model) {
            superCounterService.add();
            model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
            model.addAttribute("counter", superCounterService.getCounter());
            return "greeting";
        }
    }

}
