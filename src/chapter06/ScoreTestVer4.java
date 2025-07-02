package chapter06;

import java.util.Scanner;

public class ScoreTestVer4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu = 0;
        boolean menuFlag = true;
        int count = 0; // 등록된 학생 수 저장

        System.out.print("크기입력 > ");
        final int MAX_SIZE = scan.nextInt();

        String[] nameList = new String[MAX_SIZE];
        int[][] scoreList = new int[MAX_SIZE][];

        while (menuFlag) {
            System.out.println("---------------------------------------------");
            System.out.println("\t더조은 고등학교 성적관리 프로그램");
            System.out.println("1. 학생 등록");
            System.out.println("2. 학생 리스트 출력");
            System.out.println("3. 학생 성적 검색");
            System.out.println("4. 학생 성적 수정");
            System.out.println("5. 학생 데이터 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.println("---------------------------------------------");

            System.out.print("메뉴선택(숫자) > ");
            menu = scan.nextInt();
            int tot = 0;
            int avg = 0;

            if (menu == 1) { // 학생 등록
                for (int i = count; i < nameList.length; i++) {
                    String[] subjectList = {"국어", "영어", "수학"};
                    System.out.print("학생명 > ");
                    nameList[i] = scan.next();

                    scoreList[i] = new int[5];
                    tot = 0; // 등록 루프 내 초기화
                    for (int j = 0; j < subjectList.length; j++) {
                        System.out.print(subjectList[j] + " > ");
                        scoreList[i][j] = scan.nextInt();
                        tot += scoreList[i][j];
                    }

                    avg = tot / subjectList.length;
                    scoreList[i][3] = tot;
                    scoreList[i][4] = avg;

                    count++;

                    System.out.print("계속 입력 하시겠습니까?(계속:아무키, 종료:n) > ");
                    if (scan.next().equals("n")) {
                        i = nameList.length;
                        System.out.printf("=> %d명 등록 완료!!\n", count);
                    }
                }
            } else if (menu == 2) { // 학생 리스트 출력
                if (count != 0) {
                    System.out.println("---------------------------------------------");
                    System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
                    System.out.println("---------------------------------------------");
                    for (int i = 0; i < count; i++) {
                        System.out.print(nameList[i] + "\t");
                        for (int j = 0; j < scoreList[i].length; j++) {
                            System.out.print(scoreList[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    System.out.println("---------------------------------------------");
                } else {
                    System.out.println("=> 등록된 데이터가 없습니다. 등록을 진행해 주세요");
                }
            } else if (menu == 3) { // 학생 성적 검색
                if (count != 0) {
                    boolean searchFlag = true;
                    while (searchFlag) {
                        System.out.print("학생명 검색 > ");
                        String searchName = scan.next();
                        int searchIdx = -1;

                        for (int i = 0; i < count; i++) {
                            if (nameList[i].equals(searchName)) {
                                searchIdx = i;
                                break;
                            }
                        }

                        if (searchIdx != -1) {
                            System.out.println("검색결과 주소 : " + searchIdx);
                            System.out.println("---------------------------------------------");
                            System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
                            System.out.print(nameList[searchIdx] + "\t");

                            for (int j = 0; j < scoreList[searchIdx].length; j++) {
                                System.out.print(scoreList[searchIdx][j] + "\t");
                            }
                            System.out.println("\n---------------------------------------------");

                            System.out.print("계속 검색 하시겠습니까?(계속:아무키, 종료:n) > ");
                            if (scan.next().equals("n")) {
                                searchFlag = false;
                                System.out.println("-- 검색 종료 --");
                            }
                        } else {
                            System.out.println("=> 검색한 데이터가 없음!!");
                        }
                    }
                } else {
                    System.out.println("등록된 데이터가 없습니다.");
                }

            } else if (menu == 4) { // 학생 성적 수정
                if (count != 0) {
                    boolean modiFlag = true;
                    while (modiFlag) {
                        System.out.print("[수정]학생명 검색 > ");
                        String modifiedName = scan.next();
                        int modiIdx = -1;
                        for (int i = 0; i < count; i++) {
                            if (nameList[i].equals(modifiedName)) {
                                modiIdx = i;
                                break;
                            }
                        }

                        if (modiIdx == -1) {
                            System.out.println("수정할 데이터가 존재하지 않습니다.");
                        } else {
                            scoreList[modiIdx] = new int[5];
                            tot = 0;
                            avg = 0;
                            String[] subjectList = {"국어", "영어", "수학"};
                            for (int j = 0; j < subjectList.length; j++) {
                                System.out.print(subjectList[j] + " 점수 입력 > ");
                                scoreList[modiIdx][j] = scan.nextInt();
                                tot += scoreList[modiIdx][j];
                            }
                            avg = tot / subjectList.length;
                            scoreList[modiIdx][3] = tot;
                            scoreList[modiIdx][4] = avg;

                            System.out.println("=> 수정 완료!");
                            System.out.println("---------------------------------------------");
                            System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
                            System.out.println("---------------------------------------------");
                            for (int i = 0; i < count; i++) {
                                System.out.print(nameList[i] + "\t");
                                for (int j = 0; j < scoreList[i].length; j++) {
                                    System.out.print(scoreList[i][j] + "\t");
                                }
                                System.out.println();
                            }
                        }

                        System.out.print("계속 수정하시겠습니까?(계속:아무키, 종료:n) > ");
                        if (scan.next().equals("n")) {
                            modiFlag = false;
                        }
                    }
                } else {
                    System.out.println("등록된 데이터가 없습니다. 등록을 먼저 진행해주세요.");
                }

            } else if (menu == 5) { // 삭제
                if (count != 0) {
                    boolean deleteFlag = true;
                    while (deleteFlag) {
                        System.out.print("[삭제] 학생명 검색 > ");
                        String deleteName = scan.next();
                        int deleteIdx = -1;
                        for (int i = 0; i < count; i++) {
                            if (nameList[i].equals(deleteName)) {
                                deleteIdx = i;
                                break;
                            }
                        }

                        if (deleteIdx != -1) {
                            for (int i = deleteIdx; i < count - 1; i++) {
                                nameList[i] = nameList[i + 1];
                                scoreList[i] = scoreList[i + 1];
                            }
                            count--;
                            System.out.print("계속 삭제 하시겠습니까?(계속:아무키, 종료:n) > ");
                            if (scan.next().equals("n")) {
                                deleteFlag = false;
                            }
                        } else {
                            System.out.println("삭제할 데이터가 존재X, 다시 입력해주세요");
                        }
                    }
                } else {
                    System.out.println("등록된 데이터가 없습니다.");
                }

            } else if (menu == 9) {
                System.out.println("--프로그램 종료--");
                System.exit(0);
            } else {
                System.out.println("메뉴 준비중입니다~");
            }

            System.out.print("계속 진행 하시겠습니까?(계속:아무키, 종료:n) > ");
            if (scan.next().equals("n")) {
                menuFlag = false;
            }
        }
        System.out.println("-- 프로그램 종료 --");
    }
}
