package calculator;

public enum OperatorTypeLv3 {
    PLUS('+') { public double operate(double a, double b) {return a+b; } },
    MINUS('-') { public double operate(double a, double b) {return a-b; } },
    TIMES('*') { public double operate(double a, double b) {return a*b; } },
    DIVIDE('/') {
        public double operate(double a, double b) {
            if (b==0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            return a/b;
        }
    };

    private final char operator;
    OperatorTypeLv3(char operator) {this.operator = operator;}

    public abstract double operate(double a, double b);

    public static OperatorTypeLv3 from(char operator) {
        for (OperatorTypeLv3 v : values()) {
            if (v.operator == operator) return v;
        }
        throw new IllegalArgumentException("올바르지 않은 연산자입니다.");
    }

    @Override
    public String toString() { return String.valueOf(operator); }
}
