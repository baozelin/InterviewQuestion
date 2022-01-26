package Vmware;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.*;

public class Safe_Class {

    public class ListHepler<E> {
        public List<E> list = Collections.synchronizedList(new ArrayList<E>());
        public boolean putIfAbsent(E x){
            synchronized(list){
                boolean absent = !list.contains(x);
                if(absent)
                    list.add(x);
                return absent;
            }
        }
    }


    public final class Counter {
        private long value = 0;

        public synchronized long getValue() {
            return value;
        }

        public synchronized long increment() {
            if (value == Long.MAX_VALUE)
                throw new IllegalStateException();
            return ++value;
        }
    }




}

//实例封闭是构建线程安全类的一个最简单方式。
//
//通过将封闭机制与合适的加锁策略结合起来，可以确保以线程安全的方式来使用非线程安全的对象
//将数据封装在对象内部，可以将数据的访问限制在对象的方法上，从而更容易确保线程在访问数据时总能持有正确的锁

@ThreadSafe
class PersonSet {
    @GuardedBy("this")
    private final Set<Person> myset = new HashSet<>();

    public synchronized void addPerson(Person p) {
        myset.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return myset.contains(p);
    }

}

class Person{};

class SafePoint {
    @GuardedBy("this")
    private int x, y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//在现有的线程安全类中添加功能有以下方法：
//
//最安全的方法是修改原始的类，但通常无法做到。
//扩展一个类，假设这个类在设计时考虑了可扩展性。
//客户端加锁机制， 比较脆弱。
//组合。 推荐！！！
//客户端加锁是指：对于使用某个对象X的客户端代码，使用X本身保护其自身状态的锁在客户端保护这段代码。 所以必须知道对象X使用的是哪个锁。

class ImprovedList<T> implements List<T> {
    private final List<T> list;

    public ImprovedList(List<T> list) {
        this.list = list;
    }

    public synchronized boolean putIfAbsent(T x) {
        boolean contains = list.contains(x);

        if (!contains) {
            list.add(x);
        }

        return contains;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public synchronized void clear() {
        list.clear();
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    //按照类似的方式委托list的其他方法.
}