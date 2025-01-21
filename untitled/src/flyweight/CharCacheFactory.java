package flyweight;

import java.util.HashMap;

public class CharCacheFactory {
    HashMap<Character, ILetter> charMap = new HashMap<Character, ILetter>();

    public ILetter createLetter(char c) {
        if (charMap.containsKey(c)) {
            System.out.println("Fetching " + c + " from cache");
            return charMap.get(c);
        } else {
            System.out.println("Creating " + c);
            ILetter letter = new TextCharacter(c,"Arail",10);
            charMap.put(c, letter);
            return letter;
        }
    }
}
