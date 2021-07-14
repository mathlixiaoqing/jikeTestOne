package jike.cellPhoneNumber;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CellPhoneNumberCountMapper extends Mapper<LongWritable, Text,Text,FlowBean> {

    private Text phone = new Text();
    private FlowBean flow = new FlowBean();


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String data = value.toString();
        System.out.println("line="+data);
        //1	13736230513	192.196.100.1 www.atguigu.com 2481 24681 200
        String[] s = data.split("\t");
        System.out.println("手机号："+s[1]);
        phone.set(s[1]);
        long upFlow = Long.parseLong(s[s.length - 3]);
        long downFlow = Long.parseLong(s[s.length - 2]);

        flow.set(upFlow,downFlow);

        context.write(phone,flow);
    }
}
