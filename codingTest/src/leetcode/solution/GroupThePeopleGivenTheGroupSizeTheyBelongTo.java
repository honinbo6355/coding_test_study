package leetcode.solution;

import java.util.*;

/**
 * - https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        GroupThePeopleGivenTheGroupSizeTheyBelongTo g = new GroupThePeopleGivenTheGroupSizeTheyBelongTo();
        System.out.println(g.groupThePeople(new int[] {3,3,3,3,3,1,3}));
        System.out.println(g.groupThePeople(new int[] {2,1,3,3,3,2}));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i=0; i<groupSizes.length; i++) {
            List<List<Integer>> list = map.get(groupSizes[i]);
            if (list == null) {
                list = new ArrayList<>();
                list.add(new ArrayList<>(Arrays.asList(i)));
                map.put(groupSizes[i], list);
                continue;
            }

            List<Integer> subList = list.get(list.size() - 1);
            if (subList.size() == groupSizes[i]) {
                list.add(new ArrayList<>(Arrays.asList(i)));
            } else {
                subList.add(i);
            }
        }

        for (List<List<Integer>> list : map.values()) {
            answer.addAll(list);
        }

        return answer;
    }
}
