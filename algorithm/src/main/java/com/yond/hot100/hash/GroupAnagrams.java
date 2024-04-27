package com.yond.hot100.hash;

import java.util.*;

/**
 * @author yond
 * @date 4/17/2024
 * @description
 */
public class GroupAnagrams {

    /**
     * Example 1:
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Example 2:
     *
     * Input: strs = [""]
     * Output: [[""]]
     * Example 3:
     *
     * Input: strs = ["a"]
     * Output: [["a"]]
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            int[] hash = new int[26];
            for (char c : chars) {
                hash[c - 'a']++;
            }
            String key = Arrays.toString(hash);
            List<String> exist = groupMap.get(key);
            if (exist == null) {
                exist = new ArrayList<>();
                exist.add(strs[i]);
                groupMap.put(key, exist);
            }else {
                exist.add(strs[i]);
            }
        }
        return new ArrayList<>(groupMap.values());
    }


}
