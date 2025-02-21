package graph;

import java.util.*;

public class ReconstructItinery {
    public static void main(String[] args) {

        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        List<String> res = findItinerary(tickets);
        System.out.println(res);
    }
    public static List<String> findItinerary(List<List<String>> tickets) {

       Map<String, PriorityQueue<String>> graph = new HashMap<>();
       List<String> res = new ArrayList<>();

       for (List<String> ticket : tickets) {

           String from = ticket.get(0);
           String to = ticket.get(1);

           graph.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
       }

//       DFS("JFK", graph, res);
//
//       Collections.reverse(res);

        List<String> result = new LinkedList<>();

        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {

            String curr = stack.peek();

            if (graph.containsKey(curr) && !graph.get(curr).isEmpty()) {
                stack.push(graph.get(curr).poll());
            } else {
                result.add(stack.pop());
            }
        }
       return result;
    }


    public static void DFS(String city, Map<String, PriorityQueue<String>> graph, List<String> res) {

        PriorityQueue<String> destinations = graph.get(city);

        if (destinations == null) { return; }

            for (String dest : destinations) {
                DFS(dest, graph, res);
            }

        res.add(city);
    }
}
