public class LongestPalindromeDP {


    /**
     * DP Approach for getting longest substring Palindrome in string
     *  Time Complexity O(n2)
     *  Space Complexity O(n2)
     * @param input
     */
    private static void longestPalindrome(String input) {

        int n= input.length();
        if(n==0)
            return ;
        boolean[][] dp = new boolean[n][n];
        int max=1;
        int start=0;
        // All Substrings of length 1 are palindromes
        for(int i=0 ; i<n; i++) {
            dp[i][i] = true;
        }

        // for sub string of size 2
        for(int i=0 ; i<n-1; i++) {
            if(input.charAt(i) == input.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                max=2;
            }
        }
        // for sub string of size>2
        for(int k=3 ; k<=n; k++) {
            for(int i=0; i< n-k+1; i++) {

                int j = i+k -1;

                // for eg : for k=3 checks(i,j)-> (0,2) (1,3) (2,4)
                if(dp[i+1][j-1] && input.charAt(i)==input.charAt(j) ) {
                    dp[i][j] = true;
                    if(max < k) {
                        max =k;
                        start = i;
                    }
                }

            }
        }
        System.out.println(input.substring(start, start+max));
    }

    public static void main(String args[]) {
        longestPalindrome("theradari");
    }

}
