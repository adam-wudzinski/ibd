package ibd.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ClosedQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=1, max=255, message = "Question length should be in range between 1 and 255")
    private String question;
    @Column(name = "wrong_answer_1")
    @Size(min=1, max=50, message = "Answer length should be in range between 1 and 50")
    private String wrongAnswer1;
    @Column(name = "wrong_answer_2")
    @Size(min=1, max=50, message = "Answer length should be in range between 1 and 50")
    private String wrongAnswer2;
    @Column(name = "wrong_answer_3")
    @Size(min=1, max=50, message = "Answer length should be in range between 1 and 50")
    private String wrongAnswer3;
    @Size(min=1, max=50, message = "Answer length should be in range between 1 and 50")
    private String correctAnswer;
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @NotNull(message = "Subcategory cannot be null")
    private Subcategory subcategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
