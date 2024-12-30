package com.example.android_related.practices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Leetcode {
    public static int compareVersion(String version1, String version2) {
        int[] ver1 = getInt(version1);
        int[] ver2 = getInt(version2);
        int i = 0;
        int j = 0;
        while(i < Math.max(ver1.length, ver2.length) && j < Math.max(ver1.length, ver2.length)) {
            int value1 = i >= ver1.length ? 0 : ver1[i];
            int value2 = j >= ver2.length ? 0 : ver2[j];
            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
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
