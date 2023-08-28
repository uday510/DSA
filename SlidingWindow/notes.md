Template 1: Sliding Window (Shrinkable)
The best template I've found so far:

int i = 0, j = 0, ans = 0;
for (; j < N; ++j) {
// CODE: use A[j] to update state which might make the window invalid
for (; invalid(); ++i) { // when invalid, keep shrinking the left edge until it's valid again
// CODE: update state using A[i]
}
ans = max(ans, j - i + 1); // the window [i, j] is the maximum window we've found thus far
}
return ans;
Essentially, we want to keep the window valid at the end of each outer for loop.

Solution for this question:

What should we use as the state? It should be the sum of numbers in the window
How to determine invalid? The window is invalid if (j - i + 1) * A[j] - sum > k.
// OJ: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Author: github.com/lzl124631x
// Time: O(NlogN)
// Space: O(1)
class Solution {
public:
int maxFrequency(vector<int>& A, int k) {
sort(begin(A), end(A));
long i = 0, N = A.size(), ans = 1, sum = 0;
for (int j = 0; j < N; ++j) {
sum += A[j];
while ((j - i + 1) * A[j] - sum > k) sum -= A[i++];
ans = max(ans, j - i + 1);
}
return ans;
}
};
FAQ:

Why is the time complexity O(NlogN)?
The sorting takes O(NlogN). The two pointer part only takes O(N) because both the pointers i and j traverse the array ONLY ONCE.

Why is (j - i + 1) * A[j] - sum <= k valid?
(j - i + 1) is the length of the window [i, j]. We want to increase all the numbers in the window to equal A[j], the number of operations needed is (j - i + 1) * A[j] - sum which should be <= k. For example, assume the window is [1,2,3], increasing all the numbers to 3 will take 3 * 3 - (1 + 2 + 3) operations.

Template 2: Sliding Window (Non-shrinkable)
int i = 0, j = 0;
for (; j < N; ++j) {
// CODE: use A[j] to update state which might make the window invalid
if (invalid()) { // Increment the left edge ONLY when the window is invalid. In this way, the window GROWs when it's valid, and SHIFTs when it's invalid
// CODE: update state using A[i]
++i;
}
// after `++j` in the for loop, this window `[i, j)` of length `j - i` MIGHT be valid.
}
return j - i; // There must be a maximum window of size `j - i`.
Essentially, we GROW the window when it's valid, and SHIFT the window when it's invalid.

Note that there is only a SINGLE for loop now!

Solution for this question:

// OJ: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Author: github.com/lzl124631x
// Time: O(NlogN)
// Space: O(1)
class Solution {
public:
int maxFrequency(vector<int>& A, int k) {
sort(begin(A), end(A));
long i = 0, j = 0, N = A.size(), sum = 0;
for (; j < N; ++j) {
sum += A[j];
if ((j - i + 1) * A[j] - sum > k) sum -= A[i++];
}
return j - i;
}
};
Apply these templates to other problems
1493. Longest Subarray of 1's After Deleting One Element (Medium)
      Sliding Window (Shrinkable)
      What's state? cnt as the number of 0s in the window.
      What's invalid? cnt > 1 is invalid.
      // OJ: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
      // Author: github.com/lzl124631x
      // Time: O(N)
      // Space: O(1)
      class Solution {
      public:
      int longestSubarray(vector<int>& A) {
      int i = 0, j = 0, N = A.size(), cnt = 0, ans = 0;
      for (; j < N; ++j) {
      cnt += A[j] == 0;
      while (cnt > 1) cnt -= A[i++] == 0;
      ans = max(ans, j - i); // note that the window is of size `j - i + 1`. We use `j - i` here because we need to delete a number.
      }
      return ans;
      }
      };
      Sliding Window (Non-shrinkable)
      // OJ: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
      // Author: github.com/lzl124631x
      // Time: O(N)
      // Space: O(1)
      class Solution {
      public:
      int longestSubarray(vector<int>& A) {
      int i = 0, j = 0, N = A.size(), cnt = 0;
      for (; j < N; ++j) {
      cnt += A[j] == 0;
      if (cnt > 1) cnt -= A[i++] == 0;
      }
      return j - i - 1;
      }
      };
3. Longest Substring Without Repeating Characters (Medium)
   Sliding Window (Shrinkable)
   state: cnt[ch] is the number of occurrence of character ch in window.
   invalid: cnt[s[j]] > 1 is invalid.
   // OJ: https://leetcode.com/problems/longest-substring-without-repeating-characters/
   // Author: github.com/lzl124631x
   // Time: O(N)
   // Space: O(1)
   class Solution {
   public:
   int lengthOfLongestSubstring(string s) {
   int i = 0, j = 0, N = s.size(), ans = 0, cnt[128] = {};
   for (; j < N; ++j) {
   cnt[s[j]]++;
   while (cnt[s[j]] > 1) cnt[s[i++]]--;
   ans = max(ans, j - i + 1);
   }
   return ans;
   }
   };
   Sliding Window (Non-shrinkable)
   Note that since the non-shrinkable window might include multiple duplicates, we need to add a variable to our state.

state: dup is the number of different kinds of characters that has duplicate in the window. For example, if window contains aabbc, then dup = 2 because a and b has duplicates.
invalid: dup > 0 is invalid
// OJ: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Author: github.com/lzl124631x
// Time: O(N)
// Space: O(1)
class Solution {
public:
int lengthOfLongestSubstring(string s) {
int i = 0, j = 0, N = s.size(), cnt[128] = {}, dup = 0;
for (; j < N; ++j) {
dup += ++cnt[s[j]] == 2;
if (dup) dup -= --cnt[s[i++]] == 1;
}
return j - i;
}
};
713. Subarray Product Less Than K (Medium)
     Sliding Window (Shrinkable)
     state: prod is the product of the numbers in window
     invalid: prod >= k is invalid.
     Note that since we want to make sure the window [i, j] is valid at the end of the for loop, we need i <= j check for the inner for loop. i == j + 1 means this window is empty.

Each maximum window [i, j] can generate j - i + 1 valid subarrays, so we need to add j - i + 1 to the answer.

// OJ: https://leetcode.com/problems/subarray-product-less-than-k/
// Author: github.com/lzl124631x
// Time: O(N)
// Space: O(1)
class Solution {
public:
int numSubarrayProductLessThanK(vector<int>& A, int k) {
if (k == 0) return 0;
long i = 0, j = 0, N = A.size(), prod = 1, ans = 0;
for (; j < N; ++j) {
prod *= A[j];
while (i <= j && prod >= k) prod /= A[i++];
ans += j - i + 1;
}
return ans;
}
};
The non-shrinkable template is not applicable here since we need to the length of each maximum window ending at each position

Below is my original answer during contest. As you can see, if I don't use this template, the solution could be a bit complex.

Solution 1. Sliding Window
Let two pointers i, j form a window [i, j]. The window is valid if (j - i + 1) * A[j] - sum <= k.

We keep increasing j to expand the window as much as possible. When the window becomes invalid, we increment i.

// OJ: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Author: github.com/lzl124631x
// Time: O(NlogN)
// Space: O(1)
class Solution {
public:
int maxFrequency(vector<int>& A, int k) {
sort(begin(A), end(A));
long i = 0, j = 0, N = A.size(), ans = 1, sum = A[0];
for (; i < N; ++i) {
while (j < N && (j - i + 1) * A[j] - sum <= k) {
ans = max(ans, j - i + 1);
++j;
if (j < N) sum += A[j];
}
sum -= A[i];
}
return ans;
}
};
