package singelton;

public class Main {

    public static void main(String[] args) {
        DBC dBC = DBC.getInstance();
        System.out.println(dBC);
        DBC1 dBC1 = DBC1.getInstance();
        System.out.println(dBC1);
        DBC2 dBC2 = DBC2.getInstance();
        System.out.println(dBC2);
        DBC3 dBC3 = DBC3.getInstance();
        System.out.println(dBC3);
    }
}
