package Calculator;

public class Main {
    public static void main(String[] args) {
        Number number = new Number(5);
        Number number1 = new Number(2);
        Number number2 = new Number(3);

        Expression expression = new Expression(number1, number2, Operation.ADD);
        Expression expression1 = new Expression(number, expression, Operation.MULTIPLY);
        System.out.println(expression1.evaluate());


    }
}
