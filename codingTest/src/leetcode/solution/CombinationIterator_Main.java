package leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * - https://leetcode.com/problems/iterator-for-combination/
 */
public class CombinationIterator_Main {
    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("abc", 2);

        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
    }
}

class CombinationIterator {
    private List<String> combinations = new ArrayList<>();
    private int currentIdx = 0;

    public CombinationIterator(String characters, int combinationLength) {
        combination(new ArrayList<>(), characters, combinationLength, 0);
    }

    public String next() {
        return combinations.get(currentIdx++);
    }

    public boolean hasNext() {
        return combinations.size() > currentIdx;
    }

    private void combination(List<String> list, String characters, int combinationLength, int startIdx) {
        if (list.size() == combinationLength) {
            combinations.add(list.stream().collect(Collectors.joining()));
            return;
        }

        for (int i=startIdx; i<characters.length(); i++) {
            list.add(String.valueOf(characters.charAt(i)));
            combination(list, characters, combinationLength, i+1);
            list.remove(list.size()-1);
        }
    }
}
