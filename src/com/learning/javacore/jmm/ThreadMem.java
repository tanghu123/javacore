package com.learning.javacore.jmm;

public class ThreadMem {
    private static volatile boolean initFlag = false;

    private static void refreshFlag(){
        initFlag = true;
    }

    public static void main(String[] args){
        Thread threadA = new Thread(() -> {
            while (!initFlag){
                
            }
            System.out.println("Thread A is stopped");
        }, "ThreadA");
        threadA.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread threadB = new Thread(()->{
//            refreshFlag();
            initFlag = true;
        }, "ThreadB");
        threadB.start();
    }
}
