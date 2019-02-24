package com.zgz.zk;

/**
 *
 * 分布式锁
 */
public interface Lock {
    /**
     * 获取锁
     */
    public void getLock();

    /**
     * 释放锁
     */
    public void unLock();

}
