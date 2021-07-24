package jike.HadoopRPC.Impl;

import com.sun.istack.internal.localization.NullLocalizable;
import jike.HadoopRPC.MyInterface;
import jike.HadoopRPC.ReadFile;
import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;
import java.util.HashMap;

public class MyInterfaceImpl implements MyInterface {
    /**
     *  实现加法
     * @param number1
     * @param nunmber2
     * @return
     */
    @Override
    public int add(int number1, int nunmber2) {
        System.out.println("number1 = "+number1+"number2 = "+nunmber2);
        return number1+nunmber2;
    }

    @Override
    public String findName(String studentId) throws IOException {
        HashMap<String,String> readFile= ReadFile.readFile();
        String name= null;
        for(String key:readFile.keySet()){
            if(studentId.equals(key)){
                name=readFile.get(key);
                return name;
            }
        }
        return name;
    }

    /**
     * 返回版本号
     * @param protocol
     * @param clientVersion
     * @return
     * @throws IOException
     */
    @Override
    public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
        return MyInterface.versionID;
    }
    @Override
    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return null;

    }
}
