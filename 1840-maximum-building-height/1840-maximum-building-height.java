import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        int m = restrictions.length;

        if (m == 0) return n - 1;

        int[][] arr = new int[m + 1][2];
        arr[0][0] = 1;
        arr[0][1] = 0;

        for (int i= 0; i < m; i++) {
            arr[i + 1] = restrictions[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int r = arr.length;

    
        for (int i = 1; i < r; i++) {
            arr[i][1] = Math.min(
                arr[i][1],
                arr[i - 1][1] + (arr[i][0] - arr[i - 1][0])
            );
        }

        for (int i = r - 2; i >= 0; i--) {
            arr[i][1] = Math.min(
                arr[i][1],
                arr[i + 1][1] + (arr[i + 1][0] - arr[i][0])
            );
        }

        int ans = 0;

        for (int i = 1; i < r; i++) {
            int d = arr[i][0] - arr[i - 1][0];
            int h1 = arr[i - 1][1];
            int h2 = arr[i][1];

            ans = Math.max(ans, (h1 + h2 + d) / 2);
        }

        ans = Math.max(
            ans,
            arr[r - 1][1] + (n - arr[r - 1][0])
        );

        return ans;
    }
}