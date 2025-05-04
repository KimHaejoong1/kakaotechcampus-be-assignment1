package calculator;

import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int number1 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operation = sc.next().charAt(0);
            System.out.print("두 번째 숫자를 입력하세요: ");
            int number2 = sc.nextInt();

            int result = 0;
            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    } else {
                        result = number1 / number2;
                    }
                    break;
                default:
                    break;
            }
            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.next();
            if (answer.equals("exit")) {
                break;
            }
        }
    }
}
