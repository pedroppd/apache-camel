package br.com.apachecamel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pipeline.ValidateLine;


import javax.inject.Inject;

@SpringBootApplication
public class ApachecamelApplication extends RouteBuilder implements CommandLineRunner {

    private final String PATH = "C:\\Users\\pedro\\apache-cammel\\";

    public static void main(String[] args) {
        SpringApplication.run(ApachecamelApplication.class, args);
    }

    @Override
    public void run(String... args) {
        this.configure();
    }

    @Override
    public void configure() {
        from("file://" + PATH + "input")
                .split(body().tokenize("\n"))
                .streaming()
                .process(new ValidateLine())
                //.unmarshal()
                //.process(new ValidateLine())
                .to("file://" + PATH + "output");
    }
}
