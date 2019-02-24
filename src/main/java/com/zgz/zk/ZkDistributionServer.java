package com.zgz.zk;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

public class ZkDistributionServer extends AbstractLock{
    @Override
    void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if(countDownLatch!=null){
                    countDownLatch.countDown();
                }
            }
        };
        if(zkClient.exists(PATH)){
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /**
         * 注册节点信息
         */
        zkClient.subscribeDataChanges(PATH,iZkDataListener);
        zkClient.unsubscribeDataChanges(PATH,iZkDataListener);

    }

    @Override
    Boolean tryLock() {
        try {
            zkClient.createEphemeral(PATH);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
