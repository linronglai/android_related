package com.example.android_related.practices.leetcode;

import android.util.Pair;

import com.example.android_related.practices.OutClass;

import java.util.Stack;

public class Leetcode {
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for(int i = 0; i < length; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && stack.peek().first < temp) {
                Pair<Integer, Integer> peek = stack.peek();
                result[peek.second] = i - peek.second;
            }
            stack.push(new Pair<>(temp, i));
        }
        return result;
    }

    private static int[] getInt(String version) {
        String[] strs = version.split("\\.");
        int[] result = new int[strs.length];
        for(int i = 0; i < strs.length; i++) {
            int val = Integer.parseInt(strs[i]);
            result[i] = val;
        }
        return result;
    }
}
