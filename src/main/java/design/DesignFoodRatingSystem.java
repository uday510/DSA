package design;

import java.util.*;

public class DesignFoodRatingSystem {
    static class FoodRatings {
        Map<String, PriorityQueue<Pair>> map;
        Map<String, Pair> menu;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            map = new HashMap<>();
            menu = new HashMap<>();
            int N = foods.length;
            for (int i = 0; i < N; ++i) {
                map.computeIfAbsent(cuisines[i],
                        k -> new PriorityQueue<>((o1, o2) ->
                                o1.rating == o2.rating ? o1.food.compareTo(o2.food) : o2.rating - o1.rating));
                Pair p = new Pair(foods[i], cuisines[i], ratings[i]);
                map.get(cuisines[i]).offer(p);
                menu.put(foods[i], p);
            }
        }

        public void changeRating(String food, int newRating) {
            Pair p = menu.get(food);
            PriorityQueue<Pair> tmp = map.get(p.cuisine);
            tmp.remove(p);
            p.rating = newRating;
            tmp.offer(p);
        }

        public String highestRated(String cuisine) {
            return Objects.requireNonNull(map.get(cuisine).peek()).food;
        }
    }

    static class Pair {
        String food;
        String cuisine;
        int rating;

        public Pair(String food, String cuisine, int rating) {
            this.food = food;
            this.rating = rating;
            this.cuisine = cuisine;
        }
    }
}