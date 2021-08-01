package jike.JavaApi_Hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.NamespaceExistException;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hbase {
    public static Connection conn;
    public static Admin admin;
    public static void initConn(){
        if (null!=conn){
            System.out.println("conn has been initialed!");
            return;
        }
        Configuration conf= HBaseConfiguration.create();
        conf.set(HConstants.ZOOKEEPER_QUORUM,"47.101.204.23:2181,47.101.216.12:2181,47.101.206.249:2181");
        try {
            conn=ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void initAdmin(){
        if (conn==null){
            initConn();
        }
        if (admin!=null){
            System.out.println("admin has been got!");
            return;
        }
        try {
            admin = conn.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void close(){
        if (admin!=null){
            try {
                admin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        //创建表
        String nameSpace="percentOne";
        String tableName="percentOne:student";
        String[] familys = {"info", "score"};
        CreateTable.createTable(nameSpace,tableName,familys);
        //插入数据
        String rowkey="percentOne";
        ArrayList<Student> value=new ArrayList<>();
        Student s1=new Student("info","student_id","20210735010150");
        Student s2=new Student("info","class","2");
        Student s3=new Student("info","understanding","100");
        Student s4=new Student("info","programming","100");

        value.add(s1);
        value.add(s2);
        value.add(s3);
        value.add(s4);

        insertValues.insert(tableName, rowkey,value);
        //查询数据
        getDataFormTable.getDataFormTable(tableName,rowkey);
        //删除表
        deleteTable.deleteTable(tableName);

    }

}

