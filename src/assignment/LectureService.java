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
        //파일 입력을 위한 코드
        BufferedReader br = new BufferedReader(new FileReader(path));
        //트랜잭션 레코드의 총 개수
        int totalRecord = Integer.parseInt(br.readLine());
        //입력 n에 2를 나눈 값
        int share = totalRecord / 2;

        try {
            for (int i = 0; i < totalRecord; i++) {
                Lecture lecture = new Lecture();
                String[] input = br.readLine().split(",");
                processFile(i, lecture, input);
                //입력 n에 2를 나눈 값의 몫에 해당하는 값 번째의 트랜잭션의 실행한 뒤 중간 결과 출력
                if (i == share) {
                    printInterimResult();
                }
            }
            printTotalData();
            fileReader.close();
            fileWriter.close();
        } catch (IllegalArgumentException e) {
            //예외 발생 시 에러 메시지 콘솔에 출력
            System.out.println(e.getMessage());
        }
    }

    //파일 처리 모드 구분해 적절한 메서드 호출
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

    //중간 결과
    private void printInterimResult() throws IOException {
        repository.sortAndPrintInterimData(fileWriter);
        fileWriter.write("---------------" + "\n" + "\n");
    }

    //최종 결과
    private void printTotalData() throws IOException {
        repository.sortAndPrintTotalData(fileWriter);
    }
}
