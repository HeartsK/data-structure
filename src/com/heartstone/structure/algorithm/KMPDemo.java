package com.heartstone.structure.algorithm;

/**
 * @author
 * @date 2022-06-15 11:44
 */
public class KMPDemo {

    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int i = violenceMatch(str1, str2);
        System.out.println(i);
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
