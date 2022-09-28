public class LongestPalindrome {

    private static void getLongestPalindrome(String input) {

        int maxLength=1;
        int n= input.length();
        int low=0,high=0, start=0;

        for(int i=0 ; i<n; i++) {
            low=i-1;
            high=i+1;

            while(high<n && input.charAt(high) == input.charAt(i)) { //geeks g!=e , e==e , k!=e
                high++; //3
            }

            while(low>=0 && input.charAt(low) == input.charAt(i)) { //low<0 , g!=e, 
                low--;
            }

            while(low>=0 && high<n && input.charAt(low) == input.charAt(high)) { // low<0
                low--;
                high++;
            }
            int length = high - low - 1;
            if (maxLength < length){
                maxLength = length;
                start=low+1;
            }

        }
        System.out.println(input.substring(start, start+ maxLength));
    }

    public static void main(String args[]) {
        getLongestPalindrome("geeks");
    }
}
