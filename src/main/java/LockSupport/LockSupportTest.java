package LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
* Created by ymkNK on 2020-12-21.
*/
public class LockSupportTest {

    static int i=0;


    public static void main(String[] args) {
        // 2 threads
//        Print odd=new Print();
//        Print even=new Print();
//        Thread oddThread = new Thread(odd,"odd");
//        Thread evenThread = new Thread(even,"even");
//        odd.setT(evenThread);
//        even.setT(oddThread);
//        evenThread.start();
//        oddThread.start();
//        LockSupport.unpark(evenThread);
//
        // 3 threads
        Print firstP=new Print();
        Print secondP=new Print();
        Print thirdP=new Print();
        Thread first = new Thread(firstP,"first");
        Thread second = new Thread(secondP,"second");
        Thread third = new Thread(thirdP,"third");

        firstP.setT(second);
        secondP.setT(third);
        thirdP.setT(first);
        first.start();
        second.start();
        third.start();
        LockSupport.unpark(first);
    }

    static class Print implements Runnable{
        private Thread t;

        public void setT(Thread t) {
            this.t = t;
        }

        @Override
        public void run() {
            while (true){
                LockSupport.park();
                if (i>100){
                    LockSupport.unpark(t);
                    return;
                }
                System.out.println("print: "+i +" by:"+Thread.currentThread().getName());
                i++;
                LockSupport.unpark(t);
            }
        }
    }
}
