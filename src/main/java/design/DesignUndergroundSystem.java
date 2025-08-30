package design;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private final Map<Integer, CheckIn> active;
    private final Map<String, TripStats> stats;

    public UndergroundSystem() {
        active = new HashMap<>();
        stats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        active.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn in = active.remove(id);
        if (in == null) {
            return;
        }

        String key = key(in.station, stationName);
        TripStats tripStats = stats.computeIfAbsent(key, k -> new TripStats());
        tripStats.addTrip(t - in.time);
    }

    public double getAverageTime(String startStation, String endStation) {
        TripStats tripStats = stats.get(key(startStation, endStation));
        return tripStats == null ? -1.0 : tripStats.average();
    }

    private static String key(String src, String dest) {
        return src + " -> " + dest;
    }

    private static class CheckIn {
        final String station;
        final int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class TripStats {
        long totalTime;
        int count;
        void addTrip(int duration) {
            totalTime += duration;
            count++;
        }

        double average() {
            return (count == 0) ? -1.0 : (double) totalTime / count;
        }
    }
}


public class DesignUndergroundSystem {
}
