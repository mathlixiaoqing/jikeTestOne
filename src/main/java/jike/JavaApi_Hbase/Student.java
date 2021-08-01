package jike.JavaApi_Hbase;

public class Student {
    private  String info;
    private String col;
    private String value;

    public Student(String info, String col, String value) {
        this.info = info;
        this.col = col;
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
