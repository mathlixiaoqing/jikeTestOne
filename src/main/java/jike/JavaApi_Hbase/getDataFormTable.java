package jike.JavaApi_Hbase;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class getDataFormTable {
    public static void getDataFormTable(String tableName,String rowkey) throws IOException {
        Hbase.initAdmin();
        Admin admin = Hbase.admin;
        Connection conn = Hbase.conn;
        Table table = conn.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowkey));
        //6、调用API
        Result result = table.get(get);
        //7、遍历数据
        Cell[] cells = result.rawCells();
        for (Cell cell : cells) {
            System.out.println("rowkey :"+Bytes.toString(CellUtil.cloneRow(cell)));
            System.out.println("列族    :"+Bytes.toString(CellUtil.cloneFamily(cell)));
            System.out.println("列名    :"+Bytes.toString(CellUtil.cloneQualifier(cell)));
            System.out.println("值      :"+Bytes.toString(CellUtil.cloneValue(cell)));
            System.out.println("------------------");
        }

    }
}
