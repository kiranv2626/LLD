package momento;

public class Main {
    public static void main(String[] args) {
        ConfigOriginator originator = new ConfigOriginator(10, 20);
        ConfigCaretaker caretaker = new ConfigCaretaker();
        ConfigMomento memento = originator.createMemento();
        caretaker.addMemento(memento);

        originator.setHeight(30);
        originator.setWidth(40);

        memento = originator.createMemento();
        caretaker.addMemento(memento);

        originator.setHeight(50);
        originator.setWidth(60);

        memento = caretaker.undo();

        originator.restoreMemento(memento);

        System.out.println(originator.getHeight());
        System.out.println(originator.getWidth());
    }
}
