package Calculator;

import java.awt.*;
import java.lang.runtime.SwitchBootstraps;

public class Expression implements ArthimaticExpression{
    ArthimaticExpression left;
    ArthimaticExpression right;
    Operation operation;

    public Expression(ArthimaticExpression left, ArthimaticExpression right, Operation operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public int evaluate() {
        System.out.println("Evaluating Expression");
        int val=0;
        switch(operation){
            case ADD:
                val+= left.evaluate() + right.evaluate();
                break;
            case SUBTRACT:
                val+=left.evaluate() - right.evaluate();
                break;
            case MULTIPLY:
                val+=left.evaluate() * right.evaluate();
                break;
            case DIVIDE:
                val+=left.evaluate() / right.evaluate();
                break;
        }
        System.out.println("Value of Expression: "+ val);
        return val;

    }

}
