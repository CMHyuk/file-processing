package assignment;

import java.util.Scanner;

public class LectureController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LectureService lectureService = new LectureService();
        lectureService.run(sc);
    }
}
