package design;

import java.util.*;

public class DesignInMemoryFileSystem {
    static class FileSystem {


        static class Dir {
            Map<String, Dir> dirs = new HashMap<>();
            Map<String, String> files = new HashMap<>();
        }
        Dir root;
        public FileSystem() {
            root = new Dir();
        }
        public List<String> ls(String path) {
            Dir temp = root;
            List<String> files = new ArrayList<>();
            if (!path.equals("/")) {
                String[] d = path.split("/");
                for (int i = 1; i < d.length - 1; ++i) {
                    temp = temp.dirs.get(d[i]);
                }

                if (temp.files.containsKey(d[d.length-1])) {
                    files.add(temp.files.get(d[d.length-1]));
                    return files;
                } else {
                    temp = temp.dirs.get(d[d.length-1]);
                }
            }
            files.addAll(new ArrayList<>(temp.dirs.keySet()));
            files.addAll(new ArrayList<>(temp.files.keySet()));

            Collections.sort(files);
            return files;
        }

        public void mkdir(String path) {
            Dir temp = root;
            String[] d = path.split("/");
            for (int i = 1; i < d.length; ++i) {
                if (!temp.dirs.containsKey(d[i])) {
                    temp.dirs.put(d[i], new Dir());
                }
                temp = temp.dirs.get(d[i]);
            }
        }

        public void addContentToFile(String filePath, String content) {
        Dir temp = root;
        String[] d = filePath.split("/");

        for (int i = 1; i < d.length-1; ++i) {
            temp = temp.dirs.get(d[i]);
        }
        temp.files.put(d[d.length-1], temp.files.getOrDefault(d[d.length-1], "") + content);
        }

        public String readContentFromFile(String filePath) {
            Dir temp = root;
            String[] d = filePath.split("/");

            for (int i = 1; i < d.length-1; ++i) {
                temp = temp.dirs.get(d[i]);
            }

            return temp.files.get(d[d.length-1]);
        }
    }
}
