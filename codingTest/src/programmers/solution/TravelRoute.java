package programmers.solution;

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */

import java.util.*;

public class TravelRoute {
    public static void main(String[] args) {
        TravelRoute t = new TravelRoute();
        System.out.println(Arrays.toString(t.solution(new String[][] {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        })));
        System.out.println(Arrays.toString(t.solution(new String[][] {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL","SFO"}
        })));
    }

    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        Map<String, List<Airport>> map = new HashMap<>();
        List<Airport> arrived = new ArrayList<>();

        for (String[] ticket : tickets) {
            List<Airport> values = map.getOrDefault(ticket[0], new ArrayList<>());
            Airport airport = new Airport(ticket[1], false);
            values.add(airport);
            arrived.add(airport);
            Collections.sort(values);
            map.put(ticket[0], values);
        }

        answer.add("ICN");
        dfs(map, map.get("ICN"), answer, arrived);

        return answer.toArray(new String[0]);
    }

    private void dfs(Map<String, List<Airport>> map, List<Airport> airports, List<String> answer, List<Airport> arrived) {
        if (airports == null) {
            return;
        }

        for (Airport airport : airports) {
            if (!airport.isVisited) {
                answer.add(airport.name);
                airport.isVisited = true;
                dfs(map, map.get(airport.name), answer, arrived);
                if (arrived.stream().anyMatch(a -> !a.isVisited)) {
                    answer.remove(answer.size()-1);
                    airport.isVisited = false;
                }
            }
        }
    }
}

class Airport implements Comparable<Airport> {
    String name;
    boolean isVisited;

    Airport(String name, boolean isVisited) {
        this.name = name;
        this.isVisited = isVisited;
    }

    @Override
    public int compareTo(Airport o) {
        return name.compareTo(o.name);
    }
}
