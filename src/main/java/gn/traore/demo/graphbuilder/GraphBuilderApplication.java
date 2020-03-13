package gn.traore.demo.graphbuilder;

import com.google.gson.JsonObject;
import gn.traore.demo.graphbuilder.controller.GraphController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphBuilderApplication.class, args);
    }

    /*@Bean
    CommandLineRunner start(GraphController graphController) {
        return args -> {
            String root = graphController.transfert("debit", 1L, 2L);
            System.out.println("==== JSON ROOT => " + root);
        };
    }*/
}
