package singelton;

public class DBC2{
    private static DBC2 instance ;
    private DBC2(){

    }
    synchronized  public static DBC2 getInstance(){
        if(instance == null){

                    instance = new DBC2();
                }


        return instance;
    }
}
