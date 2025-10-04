package array;

public class FourDirsArray {

    static void main() {

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (Math.abs(dx) + Math.abs(dy) != 1) continue;
                System.out.println(dx + " " + dy);
            }
        }
    }
}
