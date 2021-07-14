package jike.cellPhoneNumber;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class CellPhoneNumberCount {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //System.setProperty("hadoop.home.dir", "D:\\install\\big_data\\hadoop\\hadoop-3.3.0");

        //1、获取一个Job实例
        Job job = Job.getInstance(new Configuration());

        //2、设置我们的类路径CLasspath
        job.setJarByClass(CellPhoneNumberCount.class);

        //3、设置Mapper和Reducer
        job.setMapperClass(CellPhoneNumberCountMapper.class);
        job.setReducerClass(CellPhoneNumberCountReducer.class);

        //4、设置Mapper和Reducer的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //5、设置输入输出数据
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //6、提交我们的Job
        boolean b = job.waitForCompletion(true);

        System.exit(b?0:1);

    }

}
