package assignment;

import java.io.IOException;

import static assignment.Config.lectureService;

public class LectureController {

    public static void main(String[] args) throws IOException {
        lectureService().run();
    }
}
