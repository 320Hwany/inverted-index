package inverted_index.dto;


import inverted_index.persistence.Lecture;

public record LectureResponse(
        long lectureId,
        String title,
        String teacher
) {

    public static LectureResponse from(final Lecture lecture) {
        return new LectureResponse(lecture.getId(), lecture.getTitle(), lecture.getTeacher());
    }
}
