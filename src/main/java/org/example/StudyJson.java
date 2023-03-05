package org.example;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudyJson {
    private String userName;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "One");
        map.put("key2", "Two");

        System.out.println("map:" + map);
        String mapJson = JSON.toJSONString(map);
        System.out.println("map转json：" + mapJson);

        StudyJson stu = new StudyJson();
        stu.setAge(18);
        stu.setUserName("张三");

        String s = JSON.toJSONString(stu);
        System.out.println("类对象转换字符串：" + s);

        JSONObject parse = JSON.parseObject(s);
        System.out.println("字符串转换成json，userName 取值：" + parse.get("userName"));

        StudyJson object = JSON.parseObject(s, StudyJson.class);
        System.out.println("字符串转换成类对象：" + object);
    }
}
