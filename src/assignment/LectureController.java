package assignment;

import java.io.IOException;

import static assignment.Config.lectureService;

/**
 * 프로그램 실행 흐름
 * lectureService().run() : 반복문을 돌면서 processFile 메서드에 있는 파일 처리 모드에 맞게 로직 수행
 * 단, 입력 n에 2를 나눈 값의 몫일 경우 해당하는 값 번째의 트랜잭션의 실행한 뒤 중간 결과 출력
 * 반복문이 끝나면 최종 결과 출력
 */
public class LectureController {

    public static void main(String[] args) throws IOException {
        //프로그램 실행
        lectureService().run();
    }
}
