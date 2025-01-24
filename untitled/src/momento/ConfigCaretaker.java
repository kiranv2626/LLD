package momento;

import java.util.ArrayList;
import java.util.List;

public class ConfigCaretaker {
    List<ConfigMomento> mementos ;

    public ConfigCaretaker() {
        this.mementos = new ArrayList<ConfigMomento>();
    }

    public void addMemento(ConfigMomento memento){
        this.mementos.add(memento);
    }
    public ConfigMomento undo()
    {
        int ind=mementos.size()-1;
        ConfigMomento memento=mementos.get(ind);
        mementos.remove(ind);
        return memento;
    }
}
