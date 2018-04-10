
package com.leetcode.domains.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.Employee;
import com.leetcode.util.parsers.string.IntParser;

public class LC690EmployeeImportance {

    public static void main(String[] args) {
        IntParser parser = new IntParser();
        int id = ArgumentParser.parseArg(args, 1, new IntParser());

        List<Employee> employees = new LinkedList<Employee>();

        System.out.println(new Solution().getImportance(employees, id));
    }

    static class Solution {

        private Map<Integer, Employee> employeeMap;
    
        private int getImportance(Employee employee) {
            int importance = employee.importance;
            
            for (int subordinate : employee.subordinates) {
                importance += getImportance(employeeMap.get(subordinate));
            }
            
            return importance;
        }
        
        public int getImportance(List<Employee> employees, int id) {
            employeeMap = new HashMap<Integer, Employee>();
            
            for (Employee employee : employees) {
                employeeMap.put(employee.id, employee);
            }
            
            return getImportance(employeeMap.get(id));
        }

    }

}