package com.example.labweek7;

import com.example.labweek7.models.Product;
import com.example.labweek7.repositories.ProductRepository;;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabWeek7Application {

    public static void main(String[] args) {
        SpringApplication.run(LabWeek7Application.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository repository) {
        return args -> {
            Faker faker =new Faker();
            for (int i = 0; i < 200; i++) {
                Product product =new Product(
                        faker.device().modelName(),
                        faker.lorem().paragraph(30),
//                        rnd.nextInt(10)%2==0?"Kg":"piece",
                        "piece",
                        faker.device().manufacturer(),
                        vn.edu.iuh.fit.backend.enums.ProductStatus.ACTIVE,
                        "https://www.google.com/url?sa=i&url=https%3A%2F%2Fhoanghamobile.com%2Fdien-thoai-di-dong%2Fapple-iphone-15-pro-256gb-chinh-hang-vn-a&psig=AOvVaw2rsA_nVORAwjvV0xviX6Zz&ust=1700555103026000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNiPmMeT0oIDFQAAAAAdAAAAABAM",
                        1000
                );
                repository.save(product);
            }
        };
    }
}
