package jp.antonsibgatulin.educationapiservice;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


class EducationApiServiceApplicationTests extends Assert {

    @Test
    void contextLoads() {
        var faker = new Faker();
        for (var i = 0; i < 200; i++) {
            System.out.println(faker.name().firstName() + "|" + faker.name().fullName() + "|" + faker.name().lastName());
        }
    }


    @Test
    void printData() {


        var faker = new Faker();
        System.out.println(faker.educator().course());
        System.out.println(faker.educator().secondarySchool());
        System.out.println(faker.educator().campus());
        System.out.println(faker.educator().university());
    }


    @Test
    void generateLessons() {

        var faker = new Faker();
        for (int x = 0; x < 1; x++) {
            var name = (faker.lorem().sentence());
            var parag = "";
            for (var j = 0; j < 5; j++) {
                parag += faker.lorem().paragraph(5) + "\n\n";
            }
        }
    }

}
