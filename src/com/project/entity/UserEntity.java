package com.project.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Pattern(regexp = "([\\u4e00-\\u9fa5]|\\w){6,9}",message = "用户名为中文或英文最多不能超过9位")
    private String username;

    @Pattern(regexp = "\\w{6,18}",message = "密码为英文或数字最多不超过18位")
    private String password;

    @Pattern(regexp = "\\w{6,18}",message = "邮箱为数字和英文的组合最多不能超过18位")
    private String email;
}
