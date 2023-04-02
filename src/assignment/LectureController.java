package assignment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LectureController {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.home") + "/Desktop/input.txt"; // 파일 경로 설정
        FileWriter writer = new FileWriter(System.getProperty("user.home") + "/Desktop/output.txt");
        FileReader filereader = new FileReader(path);
        LectureService lectureService = new LectureService();
        lectureService.run(filereader, writer, path);
        lectureService.printTotalData(writer);
        writer.close();
    }
}
