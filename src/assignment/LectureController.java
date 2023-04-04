package assignment;

import java.io.IOException;

import static assignment.Config.lectureService;

public class LectureController {

    public static void main(String[] args) throws IOException {
        //프로그램 실행
        lectureService().run();
    }
}
