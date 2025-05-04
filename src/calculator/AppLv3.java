package calculator;

import java.util.List;
import java.util.Scanner;

public class AppLv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculatorLv3<Number> calc = new ArithmeticCalculatorLv3<>();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String number1 = sc.next();
            System.out.print("두 번째 숫자를 입력하세요: ");
            String number2 = sc.next();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operation = sc.next().charAt(0);

            try {
                Number result;
                if (number1.contains(".") || number2.contains(".")) {
                    Double a = Double.parseDouble(number1);
                    Double b = Double.parseDouble(number2);
                    result = calc.calculate(a, b, OperatorTypeLv3.from(operation));
                } else {
                    Integer a = Integer.parseInt(number1);
                    Integer b = Integer.parseInt(number2);
                    result = calc.calculate(a, b, OperatorTypeLv3.from(operation));
                }
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("에러: " + e.getMessage());
            }

            System.out.print("1. 결과 조회 2. 결과 수정 3. 결과 삭제 4. 입력값 보다 큰 결과 조회: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println(calc.getResults());
                    break;
                case 2:
                    List<Number> preResults = calc.getResults();
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
                case 4:
                    System.out.print("기준값을 입력하세요: ");
                    double threshold = sc.nextDouble();
                    System.out.println(threshold + "보다 큰 결과: " + calc.greaterThan(threshold));
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
