package inverted_index.application;

import inverted_index.global.KeywordConstant;
import inverted_index.persistence.Lecture;
import inverted_index.persistence.LectureRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class LectureAppender {

    private final LectureRepository lectureRepository;
    private final LectureSearcher lectureSearcher;

    public LectureAppender(final LectureRepository lectureRepository,
                           final LectureSearcher lectureSearcher) {
        this.lectureRepository = lectureRepository;
        this.lectureSearcher = lectureSearcher;
    }

    // 테스트 데이터 저장
    @Transactional
    public void saveTestData() {
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            int keywordCount = random.nextInt(3) + 1; // 키워드 1개 ~ 3개
            List<String> shuffledKeywords = new ArrayList<>(KeywordConstant.keywords);
            Collections.shuffle(shuffledKeywords);
            List<String> selectedKeywords = shuffledKeywords.subList(0, keywordCount);

            String title = String.join(" and ", selectedKeywords) + " Course";
            String teacher = KeywordConstant.teachers.get(random.nextInt(KeywordConstant.teachers.size()));

            Lecture lecture = Lecture.builder()
                    .title(title)
                    .teacher(teacher)
                    .build();

            Lecture savedLecture = lectureRepository.save(lecture);
            lectureSearcher.putKeyword(savedLecture);
        }
    }
}
