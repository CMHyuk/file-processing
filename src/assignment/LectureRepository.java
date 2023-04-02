package assignment;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class LectureRepository {

    //정렬을 위해 TreeMap 사용
    private static Map<String, Lecture> repository = new TreeMap<>();

    public void save(Lecture lecture, int transaction) {
        try {
            isExistLecture(lecture, transaction);
            repository.put(lecture.getId(), lecture);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void isExistLecture(Lecture lecture, int transaction) {
        Collection<Lecture> lectures = repository.values();
        for (Lecture checkLecture : lectures) {
            String lectureName = checkLecture.getLectureName();
            String lectureDivision = checkLecture.getLectureDivision();
            if (lectureName.equals(lecture.getLectureName()) && lectureDivision.equals(lecture.getLectureDivision())) {
                throw new IllegalArgumentException(transaction + "번째 트랜잭션(삽입) 실행 실패[동일한 강의 이름과 분반이 존재합니다.]");
            }
        }
    }

    public void change(int transaction, String id, Lecture lecture) {
        try {
            Lecture findLecture = repository.get(id);
            if (findLecture == null) {
                throw new IllegalArgumentException(transaction + "번째 트랜잭션(수정) 실행 실패[강의 번호가 존재하지 않습니다.]");
            }
            repository.replace(lecture.getId(), lecture);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int transaction, String id) {
        try {
            Lecture findLecture = repository.get(id);
            if (findLecture == null) {
                throw new IllegalArgumentException(transaction + "번째 트랜잭션(삭제) 실행 실패[강의 번호가 존재하지 않습니다.]");
            }
            repository.remove(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sortAndPrint() {
        for (Map.Entry<String, Lecture> entry : repository.entrySet()) {
            System.out.println(getLecture(entry));
        }
    }

    private String getLecture(Map.Entry<String, Lecture> entry) {
        return entry.getValue().getId() + " " + entry.getValue().getLectureName() +
                " " + entry.getValue().getLectureRoom() + " " + entry.getValue().getLectureType() +
                " " + entry.getValue().getLectureDivision();
    }
}
