package interpret;

import java.util.HashMap;

public class Context {
    HashMap<String, Integer> variables ;

    public Context() {
        variables = new HashMap<String, Integer>();
    }
    public void put(String name, int value) {
        variables.put(name, value);
    }
    public int get(String name) {
        return variables.get(name);
    }

}
