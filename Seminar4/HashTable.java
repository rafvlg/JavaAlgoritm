package Seminar4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class HashTable<K, V> {
    private int size;
    private LinkedList<K, V>[] buckets;

    class LinkedList<K, V> {
        private List<Node<K, V>> entries;

        public LinkedList() {
            entries = new ArrayList<>();
        }

        class Node<K, V> {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        public void add(K key, V value) {
            Node<K, V> newPair = new Node<>(key, value);
            entries.add(newPair);
        }

        public List<V> find(K key) {
            List<V> values = new ArrayList<>();
            for (Node<K, V> entry : entries) {
                if (entry.key.equals(key)) {
                    values.add(entry.value);
                }
            }
            return values;
        }

        public boolean containsValue(K key, V value) {
            for (Node<K, V> entry : entries) {
                if (entry.key.equals(key) && entry.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        public boolean remove(K key) {
            Iterator<Node<K, V>> iterator = entries.iterator();
            boolean removed = false;
            while (iterator.hasNext()) {
                Node<K, V> entry = iterator.next();
                if (entry.key.equals(key)) {
                    iterator.remove();
                    removed = true;
                }
            }
            return removed;
        }
    }

    public HashTable(int size) {
        this.size = size;
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void put(K key, V value) {
        int index = hash(key);
        buckets[index].add(key, value);
    }

    public List<V> get(K key) {
        int index = hash(key);
        return buckets[index].find(key);
    }

    public boolean contains(K key, V value) {
        int index = hash(key);
        return buckets[index].containsValue(key, value);
    }

    public boolean remove(K key) {
        int index = hash(key);
        return buckets[index].remove(key);
    }
}

class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        hashTable.put("apple", 5);
        hashTable.put("banana", 10);
        hashTable.put("apple", 7);

        System.out.println(hashTable.get("apple")); //  [5, 7]
        System.out.println(hashTable.contains("apple", 7)); //  true
        System.out.println(hashTable.contains("banana", 12)); //  false

        hashTable.remove("apple");
        System.out.println(hashTable.get("apple")); //  []
    }
}