package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubfolders {
    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(removeSubfolders(folder));
    }
    private static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        var res = new ArrayList<String>();
        int len = folder.length;
        res.add(folder[0]);

        for (int idx = 1; idx < len; ++idx) {
            String lastFolder = res.getLast();
            String currentFolder = folder[idx];

            if (!currentFolder.startsWith(lastFolder + "/")) {
                res.add(currentFolder);
            }
        }
        return res;
    }
}
