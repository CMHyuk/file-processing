package assignment;

import java.util.Scanner;

public class LectureService {

    LectureRepository repository = new LectureRepository();

    public void run(Scanner sc) {
        int totalRecord = sc.nextInt();
        int share = totalRecord / 2;

        try {
            for (int i = 0; i < totalRecord; i++) {
                Lecture lecture = new Lecture();
                String[] input = sc.next().split(",");
                processFile(i, lecture, input);
                //중간 결과 출력
                if (i == share) {
                    printInterimResult();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void processFile(int i, Lecture lecture, String[] input) {
        if (input[0].equals("I")) {
            setLecture(lecture, input);
            repository.save(lecture, i + 1);
        }
        if (input[0].equals("C")) {
            setLecture(lecture, input);
            repository.change(i + 1, input[1], lecture);
        }
        if (input[0].equals("D")) {
            repository.delete(i + 1, input[1]);
        }
    }

    public void printInterimResult() {
        repository.sortAndPrint();
        System.out.println("---------------");
    }

    public void printTotalData() {
        repository.sortAndPrint();
    }

    private void setLecture(Lecture lecture, String[] input) {
        lecture.setId(input[1]);
        lecture.setLectureName(input[2]);
        lecture.setLectureRoom(input[3]);
        lecture.setLectureType(input[4]);
        lecture.setLectureDivision(input[5]);
    }
}
