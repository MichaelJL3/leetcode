
package com.leetcode.domains.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.Tuple;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC225ImplementStackUsingQueue {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        ArrayList<Tuple<String, Integer>> commands = 
            ArgumentParser.<String, Integer>parseTupleList(args, new StringParser(), new IntParser()); 

        for (Tuple<String, Integer> command : commands) {
            if (command.val1.equals("pop")) {
                System.out.println(stack.pop());
            } else if (command.val1.equals("top")) {
                System.out.println(stack.top());
            } else if (command.val1.equals("push")) {
                stack.push(command.val2);
            } else {
                System.out.println(stack.empty());
            }
        }

        System.out.println(stack);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    static class MyStack {
        Queue queue;
        
        public void push(int x) {
            Queue newQueue = new LinkedList();
            newQueue.add(x);
            newQueue.add(queue);
            queue = newQueue;
        }

        public int pop() {
            int val = (Integer) queue.poll();
            queue = (Queue) queue.poll();
            return val;
        }
        
        public int top() {
            return (Integer) queue.peek();
        }
        
        public boolean empty() {
            return queue.isEmpty();
        }

        @Override
        public String toString() {
            return queue.toString();
        }
    }
    

}