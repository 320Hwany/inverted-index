package inverted_index.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {

    @Query(value = "SELECT * FROM lecture WHERE title LIKE %:keyword%", nativeQuery = true)
    List<Lecture> findAllByKeyword(@Param("keyword") final String keyword);
}
