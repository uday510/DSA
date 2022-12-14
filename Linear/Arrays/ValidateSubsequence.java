public class ValidateSubsequence {
  public static void main(String[] args){
      int[] array = {5, 1, 22, 25, 6, -1, 8, 10};
      int[] sequence = {1, 6, -1, 19};

      System.out.println(solve(array, sequence));
  }
    public static boolean solve(int[] array, int[] sequence) {

      int seqIdx = 0;
      for(var num: array) {
          if(seqIdx == sequence.length) break;
          if(sequence[seqIdx] == num ) seqIdx++;
      }
      return seqIdx == sequence.length;
  }
}