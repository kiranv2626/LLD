package singelton;

public class DBC1 {
    private static DBC1 instance ;
    private DBC1(){ }
    public static DBC1 getInstance(){
        if(instance == null){
            instance = new DBC1();
        }
        return instance;
    }
}
