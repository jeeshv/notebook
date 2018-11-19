package com.huawei.notebook.heimaStudy.thread;

/**
 * Created by Administrator on 2018/11/10.
 * 线程通信demo: 等待唤醒机制，三个或三个以上线程通信
 */
public class Demo2_Notify {
    public static void main(String[] args) {
        final Printer p = new Printer();
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
        new Thread(){
            public void run(){
                while (true) try {
                    p.print3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class Printer{
    private int flag = 1;
    public synchronized void print1() throws InterruptedException {
        synchronized (this){
            while(flag != 1){
                this.wait();
            }
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
            flag = 2;
            this.notifyAll();
        }
    }
    public void print2() throws InterruptedException {
        synchronized (this){
            while (flag != 2) {
                this.wait();
            }
            System.out.print("传");
            System.out.print("智");
            System.out.print("播");
            System.out.print("客");
            System.out.print("\r\n");
            flag = 3;
            this.notifyAll();
        }
    }
    public void print3() throws InterruptedException {
        synchronized (this){
            while (flag != 3) {
                this.wait();
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
            this.notifyAll();
        }
    }
}
