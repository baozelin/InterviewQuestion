package Uber;


/**
 * You have token bucket initialized with TokenBucket(int tokens, int refreshrate, int capaciy);
 * You have initial tokens then for every second refreshrate tokens are added and the capacity is max tokens a bucket can have.
 * Write a void get(int amount) multithreaded function for TokenBucket class.
 * Another way to look at it : The problem is of producer and consumer but same thread consumes and produces via one get() method.
 * Following is sample code that sort of does it but it can definitely be improved.
 */
public class TokenBucket {
    int tokens,capaciy;
    double refreshrate;
    long timestamp;

    public TokenBucket(int tokens, double refreshrate, int capaciy){
        this.tokens = tokens;
        this.refreshrate =refreshrate;
        this.capaciy = capaciy;
        this.timestamp = System.currentTimeMillis();
    }


    void get(int amount) throws InterruptedException {
        synchronized (this){
            while(tokens < amount){
                System.out.println(
                        "Granting " + Thread.currentThread().getName() + " token at " + (System.currentTimeMillis() / 1000));
                Thread.sleep(1000);
                long curtime = System.currentTimeMillis();
                long diff = (curtime - timestamp)/1000;

                System.out.println(diff);
                tokens += diff * refreshrate;
                tokens = Math.min(tokens, capaciy);
                timestamp = curtime;
            }
            tokens -= amount;
        }

    }


    public static void main(String[] args) throws InterruptedException {
        TokenBucket tb = new TokenBucket(0, 4, 300);
        MyThread t1 = new MyThread(tb);
        MyThread t2 = new MyThread(tb);
        t1.start();
        t2.start();
        //tb.get(40);

    }

    static class MyThread extends Thread{
        TokenBucket tb;

        public  MyThread(TokenBucket tb){
            this.tb = tb;
        }
        @Override
        public void run() {
            int i = 0;
            while(i<1){
                System.out.println(i+" while循环");
                try {
                    tb.get(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }
}
