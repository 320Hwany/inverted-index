package inverted_index.presentation;

import inverted_index.application.LectureService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
