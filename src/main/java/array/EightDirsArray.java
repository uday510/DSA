package array;

public class EightDirsArray {

    static void main() {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                System.out.println(dx + " " + dy);
            }
        }
    }
}
