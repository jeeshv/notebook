package com.huawei.notebook.heimaStudy.socket;

import com.huawei.notebook.utils.DaNiu;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Administrator on 2018/11/18.
 */
public class Demo2_send {
    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket();
            while (true) {
                String str = DaNiu.getStr();
                DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
                socket.send(packet);
                if("exit".equals(str)){
                    System.out.println("============结束通话==============");
                    socket.close();
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
