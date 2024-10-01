package inverted_index.persistence;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    private String title;

    private String teacher;

    protected Lecture() {
    }

    @Builder

    public Lecture(final String title, final String teacher) {
        this.title = title;
        this.teacher = teacher;
    }
}
