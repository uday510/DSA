package Graph;

import java.util.*;

public class BusRoutes {
    public static void main(String[] args) {

    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        int N = routes.length;
       Map<Integer, List<Integer>> graph = new HashMap<>();

       for (int bus = 0; bus < N; ++bus) {
           for (int stop : routes[bus]) {
               graph.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
           }
       }

       Queue<Integer> queue = new LinkedList<>();
       Set<Integer> visitedStops = new HashSet<>();
       Set<Integer> visitedBuses = new HashSet<>();

       int numBuses = 0;
       queue.offer(source);

       while (!queue.isEmpty()) {
           int size = queue.size();

           for (int i = 0; i < size; ++i) {

               int currStop = queue.poll();

               for (int bus : )
           }
       }
    }
}
