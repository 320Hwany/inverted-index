package inverted_index.persistence;


import java.util.List;

public interface LectureRepository {

    Lecture save(final Lecture lecture);

    List<Lecture> findAllByKeyword(final String keyword);
}
