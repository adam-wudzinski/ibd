package ibd;

import ibd.persistence.entity.Category;
import ibd.persistence.entity.OpenQuestion;
import ibd.persistence.entity.Subcategory;
import ibd.persistence.repository.CategoryRepository;
import ibd.persistence.repository.OpenQuestionRepository;
import ibd.persistence.repository.SubcategoryRepository;
import ibd.persistence.repository.TestQuestionRepository;
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
    public CommandLineRunner loadData(CategoryRepository categoryRepository,
                                      SubcategoryRepository subcategoryRepository,
                                      OpenQuestionRepository openQuestionRepository,
                                      TestQuestionRepository testQuestionRepository) {
        return x -> {
            Category historyCategory = new Category();
            historyCategory.setName("History");
            Subcategory subcategory1 = new Subcategory();
            subcategory1.setName("Prehistory");
            subcategory1.setCategory(historyCategory);
            Subcategory subcategory2 = new Subcategory();
            subcategory2.setName("Ancient");
            subcategory2.setCategory(historyCategory);

            categoryRepository.save(historyCategory);
            subcategoryRepository.save(subcategory1);
            subcategoryRepository.save(subcategory2);

            OpenQuestion openQuestion = new OpenQuestion();
            openQuestion.setSubcategory(subcategory1);
            openQuestion.setQuestion("Hello?");
            openQuestion.setAnswer("World");
            openQuestionRepository.save(openQuestion);

            OpenQuestion openQuestion1 = new OpenQuestion();
            openQuestion1.setSubcategory(subcategory1);
            openQuestion.setQuestion("Pytanie?");
            openQuestion.setAnswer("Odpowiedz");
            openQuestionRepository.save(openQuestion1);

        };
    }
}
