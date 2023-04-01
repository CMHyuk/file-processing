package assignment;

import java.util.Scanner;

public class LectureService {

    LectureRepository repository = new LectureRepository();

    public void run(Scanner sc) {
        int totalRecord = sc.nextInt();

        try {
            for (int i = 0; i < totalRecord; i++) {
                Lecture lecture = new Lecture();
                String[] input = sc.next().split(",");
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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setLecture(Lecture lecture, String[] input) {
        lecture.setId(input[1]);
        lecture.setLectureName(input[2]);
        lecture.setLectureRoom(input[3]);
        lecture.setLectureType(input[4]);
        lecture.setLectureDivision(input[5]);
    }
}