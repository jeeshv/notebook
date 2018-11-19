package com.huawei.notebook.heimaStudy.thread;

/**
 * Created by Administrator on 2018/11/10.
 * 线程通信demo: 等待唤醒机制，两个线程的通信
 */
public class Demo1_Notify2 {
    public static void main(String[] args) {
        final Printer1 p = new Printer1();
        new Thread(){
            public void run(){
                while (true) try {
                    p.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            public void run(){
                while (true) try {
                    p.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class Printer1{
    private int flag = 1;
    public synchronized void print1() throws InterruptedException {
        synchronized (this){
            if(flag != 1){
                this.wait();
            }
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
            flag = 2;
            this.notify();
        }
    }
    public void print2() throws InterruptedException {
        synchronized (this){
            if (flag != 2) {
                this.wait();
            }
            System.out.print("传");
            System.out.print("智");
            System.out.print("播");
            System.out.print("客");
            System.out.print("\r\n");
            flag = 3;
            this.notify();
        }
    }
}
