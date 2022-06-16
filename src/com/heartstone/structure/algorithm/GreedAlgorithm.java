package com.heartstone.structure.algorithm;

import java.util.*;

/**
 * 贪心算法求解电台问题
 */
public class GreedAlgorithm {

    public static void main(String[] args) {
        Map<String, HashSet<String>> broadcast = new HashMap<>();
        HashSet<String> k1 = new HashSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");
        broadcast.put("k1",k1);
        HashSet<String> k2 = new HashSet<>();
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");
        broadcast.put("k2",k2);
        HashSet<String> k3 = new HashSet<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        broadcast.put("k3",k3);
        HashSet<String> k4 = new HashSet<>();
        k4.add("上海");
        k4.add("天津");
        broadcast.put("k4",k4);
        HashSet<String> k5 = new HashSet<>();
        k5.add("杭州");
        k5.add("大连");
        broadcast.put("k5",k5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        HashSet<String> select = new HashSet<>();
        String maxKey = null;
        HashSet<String> tempSet = new HashSet<>();
        while (allAreas.size() > 0){
            maxKey = null;
            for (String key : broadcast.keySet()) {
                tempSet.clear();
                HashSet<String> cur = broadcast.get(key);
                tempSet.addAll(cur);
                tempSet.retainAll(allAreas);
                //贪心算法的贪心之处-即每次都想取最优解
                if (tempSet.size() > 0 && (maxKey == null || broadcast.get(maxKey).size() < cur.size())){
                    maxKey = key;
                }
            }
            if (maxKey != null){
                select.add(maxKey);
                allAreas.removeAll(broadcast.get(maxKey));
            }
        }
        System.out.println(select);
    }
}
