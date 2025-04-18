package twopointer;

public class SwapAdjacentInLRString {

    public boolean canTransform(String start, String target) {
        int startCurrIdx = 0, targetCurrIdx = 0;
        int startLen = start.length();
        int targetLen = target.length();

        while (startCurrIdx < startLen || targetCurrIdx < targetLen) {

            while (startCurrIdx < startLen && start.charAt(startCurrIdx) == 'X') startCurrIdx++;

            while (targetCurrIdx < targetLen && target.charAt(targetCurrIdx) == 'X') targetCurrIdx++;

            if (startCurrIdx == startLen || targetCurrIdx == targetLen) {
                return startCurrIdx == startLen && targetCurrIdx == targetLen;
            }

            if (
                    start.charAt(startCurrIdx) != target.charAt(targetCurrIdx) ||
                            start.charAt(startCurrIdx) == 'L' && startCurrIdx < targetCurrIdx ||
                            start.charAt(startCurrIdx) == 'R' && startCurrIdx > targetCurrIdx
            )  return false;

            startCurrIdx++;
            targetCurrIdx++;
        }

        return true;
    }
}
