package com.heartstone.structure.algorithm;

import java.util.Arrays;

/**
 * @author
 * @date 2022-06-15 11:44
 */
public class KMPDemo {

    public static void main(String[] args) {
//        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
//        String str2 = "尚硅谷你尚硅你";
//        int i = violenceMatch(str1, str2);
//        System.out.println(i);
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = getNextArray(str2);
        System.out.println(Arrays.toString(next));
        int i = kmpSearch(str1, str2, next);
        System.out.println(i);
    }

    public static int kmpSearch(String str1,String str2, int[] next){
        for (int i = 0,j=0; i < str1.length();i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    public static int[] getNextArray(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1,j=0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }

    public static int violenceMatch(String str1, String str2){
        char[] origin = str1.toCharArray();
        char[] target = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < origin.length && j < target.length){
            if (origin[i] == target[j]){
                i++;
                j++;
            }else {
                i = i-j+1;
                j = 0;
            }
        }
        return i-j;
    }
}
