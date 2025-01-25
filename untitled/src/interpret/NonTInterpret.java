package interpret;

public class NonTInterpret implements Interpret {
    Interpret left;
    Interpret right;
    public NonTInterpret(Interpret left, Interpret right){
        this.left=left;
        this.right=right;
    }
    @Override
    public int interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}
