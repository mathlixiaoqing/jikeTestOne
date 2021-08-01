package jike.JavaApi_Hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

public class deleteTable {
    public static void deleteTable(String tableName) throws IOException {
        Hbase.initAdmin();
        Admin admin = Hbase.admin;
        Connection conn = Hbase.conn;
        admin.disableTable(TableName.valueOf(tableName));
        admin.deleteTable(TableName.valueOf(tableName));
    }
}
