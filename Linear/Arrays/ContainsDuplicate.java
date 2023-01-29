import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) return true;
            hashSet.add(num);
        }

        return false;

            // HashMap
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < len; i++)
//                 map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

//         for (int val : map.keySet()) {
//             if (map.get(val) > 1) return true;
//         }


        // Sorting
        // Arrays.sort(nums);
        // for (int i = 1; i < len; i++) {
        //         if (nums[i] == nums[i - 1]) return true;
        // }
        // return false;
    }
}

