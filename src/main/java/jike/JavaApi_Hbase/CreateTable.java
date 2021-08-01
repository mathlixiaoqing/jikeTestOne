package jike.JavaApi_Hbase;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;

import java.io.IOException;

public class CreateTable {
    public static void create(String tableName, String... columnFamilies) {
        Hbase.initAdmin();
        Connection conn = Hbase.conn;
        Admin admin = Hbase.admin;
        if (tableName == null || columnFamilies == null) {
            Hbase.close();
            return;
        }
        HTableDescriptor table = new HTableDescriptor(TableName.valueOf(tableName));
        for (int i = 0; i < columnFamilies.length; i++) {
            if (columnFamilies[i] == null) {
                continue;
            }
            table.addFamily(new HColumnDescriptor(columnFamilies[i]));
        }
        try {
            admin.createTable(table);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Hbase.close();
        }
    }
    /**
     * 创建表
     * @param nameSpace 命名空间
     * @param  tableName 表名
     * @param  familys 列簇
     */
    public static void  createTable(String nameSpace,String tableName, String[] familys) throws IOException {
        Hbase.initAdmin();
        Admin admin = Hbase.admin;
        CreateTable.create(tableName,familys);
    }
}
