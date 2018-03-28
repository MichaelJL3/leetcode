
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.Tuple;
import com.leetcode.util.DoubleLinkedListNode;
import com.leetcode.util.Cache;
import com.leetcode.io.ArgumentParser;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class LC146LRUCache {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("LC146LRUCache n k,v k ... k,v");
            System.exit(2);
        }

        int cacheSize = Integer.parseInt(args[0]);

        LRUCache lru = new LRUCache(cacheSize);
        IntParser parser = new IntParser();

        ArrayList<Tuple<Integer, Integer>> commands = ArgumentParser.<Integer, Integer>parseTupleList(
            Arrays.copyOfRange(args, 1, args.length), parser
        );

        for (Tuple<Integer, Integer> command : commands) {
            if (command.val2 != null) {
                lru.put(command.val1, command.val2);
            } else {
                System.out.print(lru.get(command.val1) + " ");
            }
        }

        System.out.println(lru);
    }

    static class LRUCache extends Cache<Integer, Integer> {

        private final Map<Integer, Tuple<Integer, DoubleLinkedListNode<Integer>>> cache;
        private final int cacheSize;
        private final DoubleLinkedListNode<Integer> refHead;
        private final DoubleLinkedListNode<Integer> refTail;
    
        LRUCache(int capacity) {
            cacheSize = capacity;
            cache = new HashMap<Integer, Tuple<Integer, DoubleLinkedListNode<Integer>>>(capacity);
            refHead = new DoubleLinkedListNode<Integer>(0);
            refTail = new DoubleLinkedListNode<Integer>(0);
            refHead.next = refTail;
            refTail.prev = refHead;
        }
    
        private void update(DoubleLinkedListNode<Integer> ref) {
            ref.prev.next = ref.next;
            ref.next.prev = ref.prev;
            ref.prev = refHead;
            ref.next = refHead.next;
            ref.next.prev = ref;
            refHead.next = ref;
        }
    
        private void insert(DoubleLinkedListNode<Integer> ref) {
            ref.prev = refHead;
            ref.next = refHead.next;
            ref.next.prev = ref;
            refHead.next = ref;
        }
    
        protected void evict() {
            if (refTail.prev != null) {
                if (cache.containsKey(refTail.prev.val)) {
                    cache.remove(refTail.prev.val);
                }
                if (refTail.prev.prev != null) {
                    refTail.prev.prev.next = refTail;
                }
                refTail.prev = refTail.prev.prev;
            }
        }

        public Integer get(Integer key) {
            if (cache.containsKey(key)) {
                Tuple<Integer, DoubleLinkedListNode<Integer>> keyObj = (Tuple<Integer, DoubleLinkedListNode<Integer>>) cache.get(key);
                update((DoubleLinkedListNode<Integer>) keyObj.val2);
                return (Integer) keyObj.val1;
            }
    
            return -1;
        }
        
        public void put(Integer key, Integer value) {
            if (cache.containsKey(key)) {
                Tuple<Integer, DoubleLinkedListNode<Integer>> keyObj = (Tuple<Integer, DoubleLinkedListNode<Integer>>) cache.get(key);
                keyObj.val1 = value;
                update((DoubleLinkedListNode<Integer>) keyObj.val2);
                cache.put(key, keyObj);
            } else {
                if (cacheSize == 0) return;
                else if (cache.size() >= cacheSize) {
                    evict();
                }
                DoubleLinkedListNode<Integer> keyNode = new DoubleLinkedListNode<Integer>(key);
                cache.put(key, new Tuple<Integer, DoubleLinkedListNode<Integer>>(value, keyNode));
                insert(keyNode);
            }
        }
    
        @Override
        public String toString() {
            return cache.entrySet().toString() + "\n" + refHead.toString();
        }

    }    

}
