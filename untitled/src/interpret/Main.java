package interpret;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        context.put("d", 4);
        Interpret interpret = new NonTInterpret(new NumInterpret("b"), new NumInterpret("d"));
        System.out.println(interpret.interpret(context));
    }
}
