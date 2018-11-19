package com.huawei.notebook.heimaStudy.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by Administrator on 2018/11/17.
 */
public class Demo1_Receive {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(6666);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            socket.receive(packet);

            byte[] arr = packet.getData();
            int len = packet.getLength();
            System.out.println(new String(arr,0,len));
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
