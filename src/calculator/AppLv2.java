package calculator;

import java.util.List;
import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv2 calc = new CalculatorLv2();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int number1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int number2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operation = sc.next().charAt(0);

            try {
                int result = calc.calculate(number1, number2, operation);
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("에러: " + e.getMessage());
            }

            System.out.print("1. 결과 조회 하기 2. 결과 수정 하기 3. 결과 지우기: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println(calc.getResults());
                    break;
                case 2:
                    List<Integer> preResults = calc.getResults();
                    System.out.print("변경할 결과 인덱스: ");
                    int idx = sc.nextInt();
                    if (idx < 0 || idx >= preResults.size()) {
                        System.out.println("인덱스 범위를 벗어났습니다.");
                        break;
                    }
                    System.out.print("변경할 결과 값: ");
                    int newResult = sc.nextInt();
                    preResults.set(idx, newResult);
                    calc.setResults(preResults);
                    break;
                case 3:
                    calc.removeResults();
                    break;
                default:
                    break;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.next();
            if (answer.equals("exit")) {
                break;
            }
        }
    }
}
