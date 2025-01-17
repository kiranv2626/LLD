package Calculator;

public class Number implements ArthimaticExpression {
    int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        System.out.println("Value of Expression: "+ value);
        return value;
    }
}
