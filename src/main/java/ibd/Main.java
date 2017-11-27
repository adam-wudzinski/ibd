package ibd;

import ibd.persistence.entity.*;
import ibd.persistence.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository,
                                      CategoryRepository categoryRepository,
                                      SubcategoryRepository subcategoryRepository,
                                      OpenQuestionRepository openQuestionRepository,
                                      ClosedQuestionRepository closedQuestionRepository) {
        return x -> {
            User user = new User();
            user.setLogin("admin");
            user.setPassword("admin");
            userRepository.save(user);

            Category historyCategory = new Category();
            historyCategory.setName("History");
            Category physicsCategory = new Category();
            physicsCategory.setName("Physics");
            Subcategory subcategory1 = new Subcategory();
            subcategory1.setName("Prehistory");
            subcategory1.setCategory(historyCategory);
            Subcategory subcategory2 = new Subcategory();
            subcategory2.setName("Ancient");
            subcategory2.setCategory(historyCategory);

            categoryRepository.save(historyCategory);
            categoryRepository.save(physicsCategory);
            subcategoryRepository.save(subcategory1);
            subcategoryRepository.save(subcategory2);

            OpenQuestion openQuestion = new OpenQuestion();
            openQuestion.setSubcategory(subcategory1);
            openQuestion.setQuestion("Hello?");
            openQuestion.setAnswer("World");
            openQuestionRepository.save(openQuestion);

            OpenQuestion openQuestion1 = new OpenQuestion();
            openQuestion1.setSubcategory(subcategory1);
            openQuestion1.setQuestion("Pytanie?");
            openQuestion1.setAnswer("Odpowiedz");
            openQuestionRepository.save(openQuestion1);

            ClosedQuestion closedQuestion = new ClosedQuestion();
            closedQuestion.setSubcategory(subcategory1);
            closedQuestion.setQuestion("Test question???");
            closedQuestion.setWrongAnswer1("A");
            closedQuestion.setWrongAnswer2("B");
            closedQuestion.setWrongAnswer3("C");
            closedQuestion.setCorrectAnswer("D");
            closedQuestionRepository.save(closedQuestion);
        };
    }
}
