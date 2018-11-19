package com.huawei.notebook.heimaStudy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/11/15.
 * 互斥锁
 */
public class Demo3_ReentrantLock {
    public static void main(String[] args) {
        final Printer3 p = new Printer3();
        new Thread() {
            public void run() {
                while (true) try {
                    p.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                while (true) try {
                    p.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                while (true) try {
                    p.print3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class Printer3 {
    private ReentrantLock r = new ReentrantLock();
    private Condition c1 = r.newCondition();
    private Condition c2 = r.newCondition();
    private Condition c3 = r.newCondition();
    private int flag = 1;

    public  void print1() throws InterruptedException {
        r.lock();//获取锁
        if (flag != 1) {
            c1.await();
        }
        System.out.print("黑");
        System.out.print("马");
        System.out.print("程");
        System.out.print("序");
        System.out.print("员");
        System.out.print("\r\n");
        flag = 2;
        //this.notify();
        c2.signal();
        r.unlock();//释放锁
    }

    public void print2() throws InterruptedException {
        r.lock();//获取锁
        if (flag != 2) {
            c2.await();
        }
        System.out.print("传");
        System.out.print("智");
        System.out.print("播");
        System.out.print("客");
        System.out.print("\r\n");
        flag = 3;
        //this.notify();
        c3.signal();
        r.unlock();//释放锁
    }

    public void print3() throws InterruptedException {
        r.lock();//获取锁
        if (flag != 3) {
            c3.await();
        }
        System.out.print("i");
        System.out.print("t");
        System.out.print("h");
        System.out.print("e");
        System.out.print("i");
        System.out.print("m");
        System.out.print("a");
        System.out.print("\r\n");
        flag = 1;
        //this.notifyAll();
        c1.signal();
        r.unlock();//释放锁
    }
}
