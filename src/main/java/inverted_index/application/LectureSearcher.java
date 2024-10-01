package inverted_index.application;

import inverted_index.dto.LectureResponse;
import inverted_index.global.KeywordConstant;
import inverted_index.persistence.Lecture;
import inverted_index.persistence.LectureRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class LectureSearcher {

    private final LectureRepository lectureRepository;
    private final Map<String, List<LectureResponse>> keywordInvertedIndex = new ConcurrentHashMap<>();

    public LectureSearcher(final LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    // 인터넷 강의 제목 30개 키워드로 초기화
    @PostConstruct
    public void init() {
        for (String keyword : KeywordConstant.keywords) {
            keywordInvertedIndex.put(keyword, new ArrayList<>());
        }
    }

    public void putKeyword(final Lecture lecture) {
        String title = lecture.getTitle();
        String[] tokens = title.trim().split(" ");

        for (String token : tokens) {
            if (keywordInvertedIndex.containsKey(token)) {
                List<LectureResponse> lectureResponses = keywordInvertedIndex.get(token);
                lectureResponses.add(LectureResponse.from(lecture));
            }
        }
    }

    public List<LectureResponse> findAllByKeywordWithInvertedIndex(final String keyword) {
        return keywordInvertedIndex.get(keyword);
    }

    public List<LectureResponse> findAllByKeyword(final String keyword) {
        List<Lecture> lectures = lectureRepository.findAllByKeyword(keyword);
        return lectures.stream()
                .map(LectureResponse::from)
                .collect(Collectors.toList());
    }
}
