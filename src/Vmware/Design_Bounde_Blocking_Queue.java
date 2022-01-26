package Vmware;


import java.util.LinkedList;
import java.util.Queue;

//1188
//BoundedBlockingQueue(int capacity) The constructor initializes the queue with a maximum capacity.
//void enqueue(int element) Adds an element to the front of the queue. If the queue is full, the calling thread is blocked until the queue is no longer full.
//int dequeue() Returns the element at the rear of the queue and removes it. If the queue is empty, the calling thread is blocked until the queue is no longer empty.
//int size() Returns the number of elements currently in the queue.


/**
 * 一、当两个并发线程访问同一个对象object中的这个synchronized(this) 同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
 * 　　二、当一个线程访问object的一个synchronized(this)同步代码块时，其 他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
 * 　　三、然而，当一个线程访问object的一个synchronized(this)同步代码块 时，另一个线程仍然可以访问该object中的除synchronized(this)同步代码块以外的部分。
 * 　　四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个 synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象 所有同步代码部分的访问都被暂时阻塞。
 */

public class Design_Bounde_Blocking_Queue {

    private Queue<Integer> queue;
    private Object mutex = new Object();
    private int capacity;

    public Design_Bounde_Blocking_Queue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }


    public void enqueue(int element) throws InterruptedException {
        synchronized(mutex){
            while(size() >= capacity){
                mutex.wait();  // release lock
            }

            queue.add(element);
            mutex.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        int result;
        synchronized(mutex){
            while( size() <= 0){
                mutex.wait();
            }
            result = queue.poll();
            mutex.notifyAll();
        }
        return result;
    }

    public int size() {
        return queue.size();
    }
}
