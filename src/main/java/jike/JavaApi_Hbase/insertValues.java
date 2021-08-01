package jike.JavaApi_Hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class insertValues {
    public static void insert(String tbName, String rowkey,ArrayList<Student> arrayList) throws IOException, IOException {
        Hbase.initAdmin();
        Admin admin = Hbase.admin;
        Connection conn = Hbase.conn;
        Table table = conn.getTable(TableName.valueOf(tbName));
        Put put = new Put(rowkey.getBytes());
        for (Student s1 : arrayList) {
            put.addColumn(s1.getInfo().getBytes(), s1.getCol().getBytes(), s1.getValue().getBytes());
            table.put(put);
        }
        Hbase.close();
    }
}
