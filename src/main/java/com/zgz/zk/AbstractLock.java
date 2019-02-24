package com.zgz.zk;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import java.util.concurrent.CountDownLatch;

public  abstract class AbstractLock implements Lock{
    private static final String ZKSERVER = "192.168.190.130:2181";
    protected static final String PATH = "/lock";
    private ZkConnection zkConnection =new ZkConnection(ZKSERVER,3000);
    protected ZkClient zkClient =new ZkClient(zkConnection);
    protected CountDownLatch countDownLatch =null;
    @Override
    public void getLock() {
       if(tryLock()){
           System.out.println("获取锁成功");
       }else {
           waitLock();
           getLock();
       }

    }

    /**
     * 等待锁
     */
    abstract void waitLock();

    /**
     * 如果获取成功返回true，失败返回false
     * @return
     */
    abstract Boolean tryLock();
    @Override
    public void unLock() {
        if (zkClient!=null){
            zkClient.close();
        }
    }
}
