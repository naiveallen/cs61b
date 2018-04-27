public class Palindrome {

    public Deque<Character> wordToDeque(String word) {

        Deque<Character> wordDeque = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }

        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque);
    }

    private boolean isPalindrome(Deque<Character> wordDeque) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }
        char first = wordDeque.removeFirst();
        char last = wordDeque.removeLast();

        if (first == last) {
            return isPalindrome(wordDeque);
        }

        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque, cc);
    }

    private boolean isPalindrome(Deque<Character> word, CharacterComparator cc) {
        if (word.size() == 0 || word.size() == 1) {
            return true;
        }

        char first = word.removeFirst();
        char last = word.removeLast();

        if (cc.equalChars(first, last)) {
            return isPalindrome(word, cc);
        }

        return false;

    }

}
