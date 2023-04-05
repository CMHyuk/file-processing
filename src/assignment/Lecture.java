package assignment;

/**
 * 강의실 관련 정보 클래스
 * 순서대로 강의 번호, 이름, 강의실, 유형, 분반
 */
public class Lecture {

    private String id;
    private String lectureName;
    private String lectureRoom;
    private String lectureType;
    private String lectureDivision;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureRoom() {
        return lectureRoom;
    }

    public void setLectureRoom(String lectureRoom) {
        this.lectureRoom = lectureRoom;
    }

    public String getLectureType() {
        return lectureType;
    }

    public void setLectureType(String lectureType) {
        this.lectureType = lectureType;
    }

    public String getLectureDivision() {
        return lectureDivision;
    }

    public void setLectureDivision(String lectureDivision) {
        this.lectureDivision = lectureDivision;
    }

    public void setLecture(String[] input) {
        this.setId(input[1]);
        this.setLectureName(input[2]);
        this.setLectureRoom(input[3]);
        this.setLectureType(input[4]);
        this.setLectureDivision(input[5]);
    }
}
