package LinkedIn;

public class MyHashmap {
    Entry[] map;
    int size;
    /** Initialize your data structure here. */
    public MyHashmap() {
        map = new Entry[1000001];
        size = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = new Entry(key, value);
        size++;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(map[key] == null) return -1;

        return map[key].value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = null;
        size--;
    }

    class Entry{

        int key;
        int value;

        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
