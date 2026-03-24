 import java.util.ArrayList;
import java.util.List;

public class Ugly_Number_II {

    public static void main(String[] args) {
        Ugly_Number_II out = new Ugly_Number_II();
        Solution s = out.new Solution();

        System.out.println(s.nthUglyNumber(10));
    }

    public class Solution {
        public int nthUglyNumber(int n) {
            if (n <= 0) {
                return 0;
            }

            List<Integer> nums = new ArrayList<>();
            nums.add(1);

            int i2 = 0;
            int i3 = 0;
            int i5 = 0;

            while (nums.size() < n) {

                int m2 = nums.get(i2) * 2;
                int m3 = nums.get(i3) * 3;
                int m5 = nums.get(i5) * 5;

                int mn = Math.min(Math.min(m2, m3), m5);
                nums.add(mn);

                if (mn == m2) {
                    i2++;
                }

                if (mn == m3) { // @note: 3*2 and 2*3 are both 6, so cannot else-if
                    i3++;
                }

                if (mn == m5) {
                    i5++;
                }
            }

            return nums.get(nums.size() - 1);
        }
    }
}


class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; ++i) {
            int next2 = dp[p2] * 2, next3 = dp[p3] * 3, next5 = dp[p5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) ++p2;
            if (dp[i] == next3) ++p3;
            if (dp[i] == next5) ++p5;
        }
        return dp[n - 1];
    }
}