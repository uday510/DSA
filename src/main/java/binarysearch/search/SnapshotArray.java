package binarysearch.search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class SnapshotArray {
    int snapId;
    TreeMap<Integer, Integer>[] tm;

    public SnapshotArray(int length) {
        tm = new TreeMap[length];
        snapId = 0;
        for (int i = 0; i < length; ++i) {
            tm[i] = new TreeMap<>();
            tm[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        tm[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return tm[index].floorEntry(snap_id).getValue();
    }
}


class SnapshotArrayBruteForce {

    int[] arr;
    int snapId;
    Map<Integer, int[]> map;

    public SnapshotArrayBruteForce(int length) {
        arr = new int[length];
        snapId = 0;
        map = new HashMap<>();
    }

    public void set(int index, int val) {
        arr[index] = val;
    }

    public int snap() {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) copy[i] = arr[i];

        map.put(snapId, copy);
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return map.get(snap_id)[index];
    }
}

