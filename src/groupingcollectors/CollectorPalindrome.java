package groupingcollectors;

import java.util.*;
import java.util.stream.Collectors;


class CollectorPalindrome {

    public static boolean isPalindrom(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Map<Boolean, List<String>> palindromeOrNo = Arrays.stream(words)
                .collect(Collectors.partitioningBy((CollectorPalindrome::isPalindrom))
                );
/*        Map<Boolean, List<String>> palindromeOrNot = Arrays.stream(words)
                .collect(
                        Collectors.partitioningBy(word ->
                                word.equals(new StringBuilder(word).reverse().toString())
                        )
                );*/

        palindromeOrNo = new LinkedHashMap<>(palindromeOrNo);

        System.out.println(palindromeOrNo);
    }
}
