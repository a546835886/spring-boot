package com.szr.pojo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import sun.awt.SunHints;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

public class User1 {
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "密码不能为空empty")
    @Length(min = 2, max = 10,message = "密码长度在2-10之间")
    private String password;
    @Min(value = 18)
    @Max(value = 50)
    private Integer age;

    @Email
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
