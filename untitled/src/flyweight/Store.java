package flyweight;

public class Store {
    public static void main(String[] args) {
        CharCacheFactory charCacheFactory = new CharCacheFactory();
        ILetter letter = charCacheFactory.createLetter('A');
        letter.display(1,2);
        ILetter letter1 = charCacheFactory.createLetter('B');
        letter1.display(3,4);
        ILetter letter2 = charCacheFactory.createLetter('A');
        letter2.display(5,6);
        ILetter letter3 = charCacheFactory.createLetter('B');
        letter3.display(7,8);
    }
}
