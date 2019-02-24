package com.zgz.zk;

public class ZkMain implements Runnable{

    private  Lock lock = new ZkDistributionServer();


    public static void main(String[] args){
        for(int i=0;i<100;i++){
            new Thread(new ZkMain()).start();
        }
    }

    @Override
    public void run() {
        try {
            lock.getLock();
            System.out.println(Thread.currentThread().getName());
        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unLock();
        }
    }
}
