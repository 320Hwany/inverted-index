package inverted_index.persistence;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    private String title;

    private String teacher;

    protected Lecture() {
    }

    @Builder
    private Lecture(final String title, final String teacher) {
        this.title = title;
        this.teacher = teacher;
    }
}
