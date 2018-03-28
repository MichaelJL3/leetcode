
package com.leetcode.util;

public abstract class Cache<K, V> {

    protected abstract void evict();

    public abstract V get(K key);

    public abstract void put(K key, V val);

}
