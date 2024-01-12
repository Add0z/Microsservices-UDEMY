package br.udemy.andre.bookservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/book")
public class FooBar {

    private Logger logger = LoggerFactory.getLogger(FooBar.class);

    @RequestMapping("/foo")
//    @Retry(name = "default", fallbackMethod = "fooFallbackMethod")
//    @CircuitBreaker(name = "default", fallbackMethod = "fooFallbackMethod")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String foo() {
        logger.info("Request to foo-bar is called.");
//         var response = new RestTemplate().getForEntity("http://localhost:8080/bar", String.class);


        return "foo";
//        return response.getBody();
    }

    public String fooFallbackMethod(Exception e) {
        return "foo fallback";
    }
}
