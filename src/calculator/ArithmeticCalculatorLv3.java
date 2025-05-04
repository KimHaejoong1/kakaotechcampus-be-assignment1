package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculatorLv3<T extends Number> {
    private List<T> results = new ArrayList<>();

    public T calculate(T a, T b, OperatorTypeLv3 op) {
        double result = op.operate(a.doubleValue(), b.doubleValue());
        T genericResult;
        if (a instanceof Integer && b instanceof Integer) {
            genericResult = (T) Integer.valueOf((int) result);
        }else {
            genericResult = (T) Double.valueOf(result);
        }

        results.add(genericResult);
        return genericResult;
    }

    public List<T> getResults() {
        return new ArrayList<>(results);
    }

    public void setResults(List<T> results) {
        this.results = new ArrayList<>(results);
    }

    public void removeResults() {
        if (results.isEmpty()) System.out.println("삭제할 결과가 없습니다.");
        else results.remove(0);
    }

    public List<T> greaterThan(double threshold) {
        return results.stream()
                .filter(n -> n.doubleValue() > threshold)
                .collect(Collectors.toList());
    }
}
