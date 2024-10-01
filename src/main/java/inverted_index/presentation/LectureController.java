package inverted_index.presentation;

import inverted_index.application.LectureService;
import inverted_index.dto.CollectionResponse;
import inverted_index.dto.LectureResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LectureController {

    private final LectureService lectureService;

    public LectureController(final LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping("/api/lectures")
    public void saveTestData() {
        lectureService.saveTestData();
    }

    @GetMapping("/api/lectures/inverted-index")
    public CollectionResponse<List<LectureResponse>> findAllByKeyword(@RequestParam final String keyword) {
        List<LectureResponse> lectureResponses = lectureService.findAllByKeyword(keyword);
        return CollectionResponse.of(lectureResponses);
    }
}
