package com.example.study.enums;

/**
 * 数据库类型
 */
public enum  DBTypeEnum {
    /**
     * 企业数据库
     */
    business("business"),
    /**
     * 员工数据库
     */
    employee("employee");

    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
