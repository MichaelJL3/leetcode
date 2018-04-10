
package com.leetcode.util;

import java.util.List;

public class Employee {

    public int id;
    
    public int importance;

    public List<Integer> subordinates;

    @Override
    public String toString() {
        return String.format("id: %d \nrank: %d \nemployees: %s)", 
            id, importance, subordinates.toString()); 
    }
};