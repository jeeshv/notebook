package com.huawei.notebook.heimaStudy.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Administrator on 2018/11/18.
 */
public class Demo2_Receive {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(6666);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                socket.receive(packet);

                byte[] arr = packet.getData();
                int len = packet.getLength();
                String get = new String(arr, 0, len);
                String hostAddress = packet.getAddress().getHostAddress();
                System.out.println(hostAddress + ":" + get);
                if("exit".equals(get)){
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
