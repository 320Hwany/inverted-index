package inverted_index.application;

import inverted_index.dto.LectureResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LectureService {

    private final LectureAppender lectureAppender;
    private final LectureSearcher lectureSearcher;

    public LectureService(final LectureAppender lectureAppender,
                          final LectureSearcher lectureSearcher) {
        this.lectureAppender = lectureAppender;
        this.lectureSearcher = lectureSearcher;
    }

    public void saveTestData() {
        lectureAppender.saveTestData();
    }

    public List<LectureResponse> findAllByKeyword(final String keyword) {
        return lectureSearcher.findAllByKeyword(keyword);
    }
}
