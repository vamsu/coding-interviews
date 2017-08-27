package org.vamsu.interview.solutions.strings;

/**
 * Created by vamsu on 7/30/17.
 */
public class LongestPalidrome {

    public static void main(String args[]){
        LongestPalidrome longestPalidrome = new LongestPalidrome();
        System.out.println(longestPalidrome.longestPalindrome("abaabacdef"));
    }

    public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for(int i=0;i<s.length();i++){
            System.out.println("First BEGIN: "+(i-currLength-1) + ",END: " + i);
            System.out.println("Second BEGIN: "+(i-currLength) + ",END: " + i);
            if(isPalindrome(s,i-currLength-1,i)){
                res = s.substring(i-currLength-1,i+1);
                currLength = currLength+2;
            }
            else if(isPalindrome(s,i-currLength,i)){
                res = s.substring(i-currLength,i+1);
                currLength = currLength+1;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        System.out.println("BEGIN: "+begin + ",END: " + end);
        System.out.println(s.substring(begin,end));
        while(begin<end){
            if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }

}
