package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static assignment.Const.path;

public class LectureService {

    private final LectureRepository repository;
    private final FileWriter fileWriter;
    private final FileReader fileReader;

    public LectureService(LectureRepository repository, FileWriter fileWriter, FileReader fileReader) {
        this.repository = repository;
        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        int totalRecord = Integer.parseInt(br.readLine());
        int share = totalRecord / 2;

        try {
            for (int i = 0; i < totalRecord; i++) {
                Lecture lecture = new Lecture();
                String[] input = br.readLine().split(",");
                processFile(i, lecture, input);
                //중간 결과 출력
                if (i == share) {
                    printInterimResult();
                }
            }
            printTotalData();
            fileReader.close();
            fileWriter.close();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void processFile(int i, Lecture lecture, String[] input) {
        if (input[0].equals("I")) {
            lecture.setLecture(input);
            repository.save(lecture, i + 1);
        }
        if (input[0].equals("C")) {
            lecture.setLecture(input);
            repository.change(i + 1, input[1], lecture);
        }
        if (input[0].equals("D")) {
            repository.delete(i + 1, input[1]);
        }
    }

    private void printInterimResult() throws IOException {
        repository.sortAndPrintInterimData(fileWriter);
        fileWriter.write("---------------" + "\n" + "\n");
    }

    private void printTotalData() throws IOException {
        repository.sortAndPrintTotalData(fileWriter);
    }
}
