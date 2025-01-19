package singelton;

public class DBC3 {
    private static DBC3 instance ;
    private DBC3(){

    }
    public static DBC3 getInstance(){
        if(instance == null){
            synchronized (DBC3.class) {
                if(instance == null){
                    instance = new DBC3();
                }
            }
        }
        return instance;
    }
}
