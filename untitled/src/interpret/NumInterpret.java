package interpret;

public class NumInterpret implements Interpret {
    String value;
    NumInterpret(String value){
        this.value=value;
    }
    @Override
    public int interpret(Context context) {
        return context.get(value);
    }
}
