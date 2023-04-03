package assignment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static assignment.Const.*;

public class Config {

    public static LectureService lectureService() throws IOException {
        return new LectureService(new LectureRepository(), fileWriter(), fileReader());
    }

    public static FileWriter fileWriter() throws IOException {
        return new FileWriter(System.getProperty("user.home") + "/Desktop/output.txt");
    }

    public static FileReader fileReader() throws FileNotFoundException {
        return new FileReader(path);
    }
}
