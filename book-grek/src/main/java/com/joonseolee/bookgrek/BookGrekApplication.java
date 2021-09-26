package com.joonseolee.bookgrek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class BookGrekApplication {

    public static void main(String[] args) {
        // template 엔진은 블록킹이기때문에 해당 부분은 제외
        BlockHound.builder()
                .allowBlockingCallsInside(
                        TemplateEngine.class.getCanonicalName(), "process")
                .install();
        SpringApplication.run(BookGrekApplication.class, args);
    }

}
