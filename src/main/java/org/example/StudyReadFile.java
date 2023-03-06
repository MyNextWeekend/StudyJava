package org.example;

public class StudyReadFile {
    public static void main(String[] args) {
        // 不同系统对应的分隔符不一样
        String separator = System.getProperty("file.separator");
        System.out.println(separator);

    }
}
