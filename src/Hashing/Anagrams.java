package Hashing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next();
        String secondWord = scanner.next();
/*        if (CharactersCalculator(firstWord.toUpperCase()).equals(CharactersCalculator(secondWord.toUpperCase()))) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }*/
        System.out.println(DifferencesRemover(firstWord.toLowerCase(), secondWord.toLowerCase()));
    }
    public static Map<Character, Integer> CharactersCalculator(String word) {
        Map<Character, Integer> mapOfAnagrams = new HashMap<>();
        char firstElement = word.charAt(0);
        int counter = 0;
        Set<Character> characters = new HashSet<>();
        characters.add(firstElement);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != firstElement) {
                characters.add(word.charAt(i));
                firstElement = word.charAt(i);
            }
        }
        for (int j = 0; j < characters.size(); j++) {
            firstElement = characters.stream().toList().get(j);
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == firstElement) {
                    counter++;
                }
                if (i == word.length() - 1) {
                    mapOfAnagrams.put(firstElement, counter);
                    counter = 0;
                }
            }
        }
        return mapOfAnagrams;
    }
    public static int DifferencesRemover(String word1, String word2) {
        Map<Character, Integer> map1 = CharactersCalculator(word1);
        Map<Character, Integer> map2 = CharactersCalculator(word2);
        int counter = 0;
        for (Character key : map2.keySet()
             ) {
            if (!map1.containsKey(key)) {
                counter += map2.get(key);
            } else {
                if (!Objects.equals(map2.get(key), map1.get(key))) {
                    counter += Math.abs(map2.get(key) - map1.get(key));
                }
            }
        }
        for (Character key : map1.keySet()
        ) {
            if (!map2.containsKey(key)) {
                counter += map1.get(key);
            }
        }
        return counter;
    }
}
