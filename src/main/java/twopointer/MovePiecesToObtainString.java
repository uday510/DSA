package twopointer;

public class MovePiecesToObtainString {

    public boolean canChange(String start, String target) {
        int startCurrIdx = 0, targetCurrIdx = 0;
        int startLen = start.length();
        int targetLen = target.length();

        while (startCurrIdx < startLen || targetCurrIdx < targetLen) {

            while (startCurrIdx < startLen && start.charAt(startCurrIdx) == '_') startCurrIdx++;

            while (targetCurrIdx < targetLen && target.charAt(targetCurrIdx) == '_') targetCurrIdx++;

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
