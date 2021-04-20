package net.rnd.talkwalker;

public class Palindrome {

    public static void main(String[] ar){

        System.out.println(longestPalSubstr("aaaanaaittaiknatt"));
        System.out.println(longestPalSubstr("xyzfghiihgfedcba"));
    }

    static int longestPalSubstr(String str)
    {
        // get length of input String
        int length = str.length();

        // All subStrings of length 1
        // are palindromes
        int maxLength = 1, start = 0;

        // Nested loop to mark start and end index
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++) {
                    if (str.charAt(i + k) != str.charAt(j - k)) {
                        flag = 0;
                    }
                }
                // Palindrome
                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        System.out.print("Longest palindrome subString is: ");
        System.out.println("palindrome: "+str.substring(start,start+maxLength));
        //printSubStr(str, start, start + maxLength - 1);

        // return length of LPS
        return maxLength;
    }


}
