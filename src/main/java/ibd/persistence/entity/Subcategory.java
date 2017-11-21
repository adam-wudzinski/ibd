package ibd.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.REMOVE)
    private List<OpenQuestion> openQuestion;
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.REMOVE)
    private List<ClosedQuestion> closedQuestions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OpenQuestion> getOpenQuestion() {
        return openQuestion;
    }

    public void setOpenQuestion(List<OpenQuestion> openQuestion) {
        this.openQuestion = openQuestion;
    }

    public List<ClosedQuestion> getClosedQuestions() {
        return closedQuestions;
    }

    public void setClosedQuestions(List<ClosedQuestion> closedQuestions) {
        this.closedQuestions = closedQuestions;
    }
}
