
package com.leetcode.domains.algorithms;

import java.util.ArrayList;
import java.util.Stack;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.Tuple;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC232ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        ArrayList<Tuple<String, Integer>> commands = 
            ArgumentParser.<String, Integer>parseTupleList(args, new StringParser(), new IntParser()); 

        for (Tuple<String, Integer> command : commands) {
            if (command.val1.equals("pop")) {
                System.out.println(queue.pop());
            } else if (command.val1.equals("peek")) {
                System.out.println(queue.peek());
            } else if (command.val1.equals("push")) {
                queue.push(command.val2);
            } else {
                System.out.println(queue.empty());
            }
        }

        System.out.println(queue);
    }

    static class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> queue; 
        
        public MyQueue() {
            stack = new Stack<Integer>();
            queue = new Stack<Integer>();
        }
        
        private void transfer() {
            while (!stack.empty()) {
                queue.push(stack.pop());
            }
        }

        public void push(int x) {
            stack.push(x);
        }
        
        public int pop() {
            if (queue.empty()) transfer();

            return queue.pop();
        }
        
        public int peek() {
            if (queue.empty()) transfer();

            return queue.peek();
        }
        
        public boolean empty() {
            return stack.empty() && queue.empty();
        }

        @Override
        public String toString() {
            return String.format("[%s] [%s]", stack, queue);
        }
    }

}