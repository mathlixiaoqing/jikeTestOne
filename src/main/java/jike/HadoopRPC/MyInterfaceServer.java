package jike.HadoopRPC;

import jike.HadoopRPC.Impl.MyInterfaceImpl;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;


import java.io.IOException;

/**
 * @author 澡雪青
 */
public class MyInterfaceServer {
    public static final String SERVER_ADDRESS="localhost";
    public static final int SERVER_PORT=12345;
    public static void main(String[] args){
        RPC.Builder builder=new RPC.Builder(new Configuration());
        //服务器IP 地址
        builder.setBindAddress("127.0.0.1");
        //端口号
        builder.setPort(12345);

        builder.setProtocol(MyInterface.class);
        builder.setInstance(new MyInterfaceImpl());
        try {
            RPC.Server server=builder.build();
            server.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
