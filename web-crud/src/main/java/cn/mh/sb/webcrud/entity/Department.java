package cn.mh.sb.webcrud.entity;

import lombok.Data;

@Data
public class Department {

    private Integer id;
    private String departmentName;

    public Department(int i, String s) {
        this.id = id;
        this.departmentName = s;
    }
}
