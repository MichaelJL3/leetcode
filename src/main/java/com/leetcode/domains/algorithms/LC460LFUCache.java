
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.Cache;
import com.leetcode.util.Tuple;
import com.leetcode.util.DoubleLinkedList;
import com.leetcode.util.DoubleLinkedListNode;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class LC460LFUCache {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("LC146LRUCache n k,v k ... k,v");
            System.exit(2);
        }

        int cacheSize = Integer.parseInt(args[0]);

        LFUCache<Integer, Integer> lfu = new LFUCache<Integer, Integer>(cacheSize);
        IntParser parser = new IntParser();

        ArrayList<Tuple<Integer, Integer>> commands = ArgumentParser.<Integer, Integer>parseTupleList(
            Arrays.copyOfRange(args, 1, args.length), parser
        );

        for (Tuple<Integer, Integer> command : commands) {
            if (command.val2 != null) {
                lfu.put(command.val1, command.val2);
            } else {
                System.out.print(lfu.get(command.val1) + " ");
            }
        }

        System.out.println(lfu);
    }

    @SuppressWarnings("rawtypes")
    static class LFUCache<K, V> extends Cache<K, V> {
        private final Integer MIN_COUNT = 1;
        private final Integer NOT_FOUND = -1;
        private final int cacheSize;
        private final Map<K, Tuple<DoubleLinkedListNode<Tuple<K, V>>, 
            DoubleLinkedListNode<Tuple<Integer, DoubleLinkedList<Tuple<K, V>>>>>> cache;
        private final DoubleLinkedList<Tuple<Integer, DoubleLinkedList<Tuple<K, V>>>> counts;

        public LFUCache(int capacity) {
            cacheSize = capacity;
            cache = new HashMap(capacity);
            counts = new DoubleLinkedList();
        }

        public void put(K key, V value) {
            if (cacheSize == 0) return;

            if (cache.containsKey(key)) {
                Tuple tup = cache.get(key);
                ((DoubleLinkedListNode<Tuple>) tup.val1).val.val2 = value;
                update(tup);
            } else {
                if (cacheSize == cache.size()) evict();
                Tuple tup = insert(new DoubleLinkedListNode(new Tuple(key, value)));
                cache.put(key, tup);
            }
        }

        public V get(K key) {
            if (cache.containsKey(key)) {
                Tuple tup = cache.get(key);
                V val = (V) ((DoubleLinkedListNode<Tuple>) tup.val1).val.val2;
                update(tup);
                return val;
            }

            return (V) NOT_FOUND;
        }

        private Tuple insert(DoubleLinkedListNode val) {
            DoubleLinkedListNode node = null;
            DoubleLinkedList nodelist = null;

            if (!counts.empty() && (Integer) counts.head.next.val.val1 == MIN_COUNT) {
                nodelist = (DoubleLinkedList) counts.head.next.val.val2;
                nodelist.insertAtHead(val);
                node = counts.head.next;
            } else {
                nodelist = new DoubleLinkedList();
                nodelist.insertAtHead(val);
                node = counts.insertAtHead(new Tuple(MIN_COUNT, nodelist));
            }

            return new Tuple(val, node);
        }

        private void update(Tuple tup) {
            DoubleLinkedListNode<Tuple<Integer, DoubleLinkedList<Tuple<K, V>>>> cntNode = (DoubleLinkedListNode) tup.val2;
            DoubleLinkedListNode valNode = (DoubleLinkedListNode) tup.val1; 
            DoubleLinkedList nodelist = null;
            Integer count = (Integer) cntNode.val.val1 + 1;

            valNode.removeNode();
            
            if (cntNode.next == counts.tail || (Integer) cntNode.next.val.val1 != count) {
                nodelist = new DoubleLinkedList();
                nodelist.insertAtHead(valNode);
                tup.val2 = cntNode.insertNode(new Tuple(count, nodelist));
            } else {
                nodelist = cntNode.next.val.val2;
                nodelist.insertAtHead(valNode);
                tup.val2 = cntNode.next;
            }

            if (cntNode.val.val2.empty()) {
                cntNode.removeNode();
            }
        }

        protected void evict() {
            DoubleLinkedList<Tuple<K, V>> nodelist = counts.head.next.val.val2;
            DoubleLinkedListNode<Tuple<K, V>> node = nodelist.tail.prev;

            cache.remove(node.val.val1);
            node.removeNode();
            if (nodelist.empty()) {
                counts.head.next.removeNode();
            }
        }

        @Override
        public String toString() {
            return String.format("%s\n%s", cache.entrySet().toString(), counts.toString());
        }

    }

}