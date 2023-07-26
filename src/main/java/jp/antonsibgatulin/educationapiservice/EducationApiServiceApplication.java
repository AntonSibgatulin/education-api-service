package jp.antonsibgatulin.educationapiservice;

import com.github.javafaker.Faker;
import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.teacher.Expirience;
import jp.antonsibgatulin.educationapiservice.entity.teacher.Teacher;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import jp.antonsibgatulin.educationapiservice.enums.TypeItem;
import jp.antonsibgatulin.educationapiservice.repository.ItemRepository;
import jp.antonsibgatulin.educationapiservice.repository.TeacherRepository;
import jp.antonsibgatulin.educationapiservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Random;

@SpringBootApplication
public class EducationApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationApiServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner generateData(UserRepository userRepository, TeacherRepository teacherRepository,
                                          ItemRepository itemRepository) {
        return args -> {


            System.out.println("==================================//////////START GENERATE DATE///////==================================");
            var faker = new Faker();

            for (int i = 0; i < 500; i++) {
                var user = new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), faker.internet().password(6, 16));
                user.create();
                userRepository.save(user);

                var teacher = new Teacher(faker.name().nameWithMiddle(), user);
                //teacherRepository.save(teacher);

                var list = new ArrayList<Expirience>();

                for (var j = 0; j < 1 + new Random().nextInt(4); j++) {
                    var exp = new Expirience(faker.educator().course(), 1 + new Random().nextInt(10));
                    list.add(exp);
                }
                teacher.setExpirienceList(list);
                teacherRepository.save(teacher);

                for (int x = 0; x < 1 + new Random().nextInt(); x++) {
                    var name = (faker.lorem().sentence());
                    var parag = "";
                    for (var j = 0; j < 5; j++) {
                        parag += faker.lorem().paragraph(5) + "\n\n";
                    }
                    var item = new Item(name, parag, teacher, 50 + new Random().nextInt(500), 300, 100, null, TypeItem.NEW);

                    itemRepository.save(item);


                }


                System.out.println();
                for (var x = 0; x < i; x++) {
                    System.out.print("=");
                }
                System.out.print(">");
                for (var x = i; x < 500 - 1; x++) {
                    System.out.print("-");
                }
            }

        };
    }
}
