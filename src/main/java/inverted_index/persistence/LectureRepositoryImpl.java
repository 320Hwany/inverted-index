package inverted_index.persistence;

import org.springframework.stereotype.Repository;


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
}
