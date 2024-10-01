package inverted_index.persistence;


import java.util.List;

public interface LectureRepository {

    void saveAll(final List<Lecture> lectures);
}
