package singelton;

public class DBC {
    private static DBC instance=new DBC();
    private DBC(){

    }
    public static DBC getInstance(){
        return instance;
    }
}
