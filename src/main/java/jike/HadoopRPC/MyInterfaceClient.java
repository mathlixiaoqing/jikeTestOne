package jike.HadoopRPC;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;


public class MyInterfaceClient {
    public static void main(String[] args){
        try {
            if(1==1){
                MyInterface myInterface= RPC.getProxy(MyInterface.class,1L,
                        new InetSocketAddress(MyInterfaceServer.SERVER_ADDRESS,MyInterfaceServer.SERVER_PORT),
                        new Configuration());
                // int res=myInterface.add(1,2);
                // System.out.println(res);
                Scanner sc=new Scanner(System.in);
                String name=myInterface.findName(sc.next());
                System.out.println(name);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
