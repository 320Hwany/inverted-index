package inverted_index.application;

import inverted_index.persistence.Lecture;
import inverted_index.persistence.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    public LectureService(final LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    // 인터넷 강의 제목 30개 키워드
    private final List<String> keywords = List.of(
            "Java", "Spring", "Hibernate", "JPA", "Redis",
            "ElasticSearch", "Kafka", "Docker", "Kubernetes", "CI/CD",
            "API", "OAuth", "JWT", "Restful", "Microservices",
            "AWS", "GCP", "Azure", "Linux", "Nginx",
            "MySQL", "PostgreSQL", "MongoDB", "GraphQL", "React",
            "Vue", "Angular", "TypeScript", "Python", "Node.js"
    );

    // 강의자 5명 키워드
    private final List<String> teachers = List.of(
            "김영한", "토비", "백기선", "향로", "제미니"
    );

    // 테스트 데이터 저장
    @Transactional
    public void saveTestData() {
        List<Lecture> lectures = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            int keywordCount = random.nextInt(3) + 1; // 키워드 1개 ~ 3개
            List<String> shuffledKeywords = new ArrayList<>(keywords);
            Collections.shuffle(shuffledKeywords);
            List<String> selectedKeywords = shuffledKeywords.subList(0, keywordCount);

            String title = String.join(" and ", selectedKeywords) + " Course";
            String teacher = teachers.get(random.nextInt(teachers.size()));

            Lecture lecture = Lecture.builder()
                    .title(title)
                    .teacher(teacher)
                    .build();

            lectures.add(lecture);
        }

        lectureRepository.saveAll(lectures);
    }
}
