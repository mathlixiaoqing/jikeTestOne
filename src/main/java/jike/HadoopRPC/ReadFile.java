package jike.HadoopRPC;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {


    public static HashMap<String,String> readFile() throws IOException {
        HashMap<String,String> readFile=new HashMap<String, String>();
        //读取文件
        String file="D:\\coder\\lixiaoqing\\src\\main\\resources\\HadoopRPC\\roster.txt";
        List<String> allList= Files.readAllLines(Paths.get(file));
        for (String line:allList){
            if (line != "") {
                String[] temp = line.split(",");

                if (temp.length == 2) {
                    readFile.put(temp[0], temp[1]);
                }
            }
        }

        return readFile;
    }
}
