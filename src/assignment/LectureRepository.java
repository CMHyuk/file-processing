package assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class LectureRepository {

    //정렬을 위해 TreeMap 사용
    private static final Map<String, Lecture> repository = new TreeMap<>();

    //저장
    public void save(Lecture lecture, int transaction) {
        isExistLecture(lecture, transaction);
        repository.put(lecture.getId(), lecture);
    }

    private void isExistLecture(Lecture lecture, int transaction) {
        Collection<Lecture> lectures = repository.values();
        for (Lecture checkLecture : lectures) {
            String lectureId = checkLecture.getId();
            String lectureName = checkLecture.getLectureName();
            String lectureDivision = checkLecture.getLectureDivision();
            //예외 1. 삽입 시 동일한 강의 번호의 레코드가 이미 존재하는 경우
            if (lectureId.equals(lecture.getId())) {
                throw new IllegalArgumentException(transaction + "번째 트랜잭션(삽입) 실행 실패[동일한 강의 번호가 존재합니다.]");
            }
            //예외 2. 삽입 시 동일한 강의 이름과 분반을 가진 강의가 이미 존재하는 경우
            if (lectureName.equals(lecture.getLectureName()) && lectureDivision.equals(lecture.getLectureDivision())) {
                throw new IllegalArgumentException(transaction + "번째 트랜잭션(삽입) 실행 실패[동일한 강의 이름과 분반이 존재합니다.]");
            }
        }
    }

    //수정
    public void change(int transaction, String id, Lecture lecture) {
        Lecture findLecture = repository.get(id);
        //예외 3. 수정 시 해당 트랜잭션이 가리키는 강의 번호가 존재하지 않는 경우
        if (findLecture == null) {
            throw new IllegalArgumentException(transaction + "번째 트랜잭션(수정) 실행 실패[강의 번호가 존재하지 않습니다.]");
        }
        repository.replace(lecture.getId(), lecture);
    }

    //삭제
    public void delete(int transaction, String id) {
        Lecture findLecture = repository.get(id);
        //예외 4. 삭제 시 해당 트랜잭션이 가리키는 강의 번호가 존재하지 않는 경우
        if (findLecture == null) {
            throw new IllegalArgumentException(transaction + "번째 트랜잭션(삭제) 실행 실패[강의 번호가 존재하지 않습니다.]");
        }
        repository.remove(id);
    }

    //getTotalData에서 반환된 데이터 오름차순으로 정렬 후 파일에 저장
    public void sortAndPrintTotalData(FileWriter fileWriter) throws IOException {
        for (Map.Entry<String, Lecture> entry : repository.entrySet()) {
            fileWriter.write(getTotalData(entry) + "\n");
        }
    }

    //최종 데이터 반환
    public String getTotalData(Map.Entry<String, Lecture> entry) {
        return entry.getValue().getId() + " " + entry.getValue().getLectureName() +
                " " + entry.getValue().getLectureRoom() + " " + entry.getValue().getLectureType() +
                " " + entry.getValue().getLectureDivision();
    }

    //getInterimData에서 반환된 데이터 오름차순으로 정렬 후 파일에 저장
    public void sortAndPrintInterimData(FileWriter fileWriter) throws IOException {
        for (Map.Entry<String, Lecture> entry : repository.entrySet()) {
            fileWriter.write(getInterimData(entry) + "\n");
        }
    }

    //중간 결과 - 강의 번호, 이름, 분반 반환
    private String getInterimData(Map.Entry<String, Lecture> entry) {
        return entry.getValue().getId() + " " + entry.getValue().getLectureName() +
                " " + entry.getValue().getLectureDivision();
    }
}
