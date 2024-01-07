package com.sort.Enum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/07/12:38
 */
public enum ObjectEnum {

    ADMINISTRATOR(1,"administrator"),
    ADMIN(2,"admin");

    private int id;

    private String role;

    ObjectEnum(int id,String role){
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ObjectEnum{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
