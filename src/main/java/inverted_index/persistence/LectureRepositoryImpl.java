package inverted_index.persistence;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class LectureRepositoryImpl implements LectureRepository {

    private final LectureJpaRepository lectureJpaRepository;

    public LectureRepositoryImpl(final LectureJpaRepository lectureJpaRepository) {
        this.lectureJpaRepository = lectureJpaRepository;
    }

    @Override
    public Lecture save(final Lecture lecture) {
        return lectureJpaRepository.save(lecture);
    }

    @Override
    public List<Lecture> findAllByKeyword(final String keyword) {
        return lectureJpaRepository.findAllByKeyword(keyword);
    }
}
