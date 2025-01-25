package graph;

import java.util.*;

public class BusRoutes {
    public static void main(String[] args) {

        String[][] routes = {{"a", "b" , "g"}, {"c", "e", "g"}, {"c", "f", "h"}};

        System.out.println(numBusesToDestination(routes, "a", "h"));
    }

    public static int numBusesToDestination(String[][] routes, String source, String target) {
        if (Objects.equals(source, target)) {
            return 0;
        }

        HashMap<String, ArrayList<Integer>> adjList = new HashMap<>();
        // Create a map from the bus stop to all the routes that include this stop.
        for (int r = 0; r < routes.length; r++) {
            for (String stop : routes[r]) {
                // Add all the routes that have this stop.
                ArrayList<Integer> route = adjList.getOrDefault(stop, new ArrayList<>());
                route.add(r);
                adjList.put(stop, route);
            }
        }
//        System.out.println(adjList);

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<Integer>(routes.length);
        // Insert all the routes in the queue that have the source stop.
        for (int route : adjList.get(source)) {
            q.add(route);
            vis.add(route);
        }

        int busCount = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int route = q.remove();

                // Iterate over the stops in the current route.
                for (String stop: routes[route]) {
                    // Return the current count if the target is found.
                    if (Objects.equals(stop, target)) {
                        return busCount;
                    }

                    // Iterate over the next possible routes from the current stop.
                    for (int nextRoute : adjList.get(stop)) {
                        System.out.println(stop +  " --> " + nextRoute);
                        if (!vis.contains(nextRoute)) {
                            vis.add(nextRoute);
                            q.add(nextRoute);
                        }
                    }
                    System.out.println("-----");
                }
            }
            busCount++;
        }
        return -1;
    }
}
