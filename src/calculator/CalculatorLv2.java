package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorLv2 {
    private List<Integer> results = new ArrayList<>();

    public int calculate(int a, int b, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b==0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                result = a / b;
                break;
            default:
                break;
        }
        results.add(result);
        return result;
    }
    public List<Integer> getResults() {
        return new ArrayList<>(results);
    }

    public void setResults(List<Integer> results) {
        this.results = new ArrayList<>(results);
    }

    public void removeResults() {
        if (results.isEmpty()) System.out.println("삭제할 결과가 없습니다.");
        else results.remove(0);
    }
}
