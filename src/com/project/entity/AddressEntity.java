package com.project.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
public class AddressEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String username;

    @NotEmpty(message = "名称不能为空")
    private String name;

    @NotEmpty(message = "性别不能为空")
    private String sex;

    @Pattern(regexp = "\\d{11}",message = "电话号码为11位的数字")
    private String mobile;

    @Pattern(regexp = "\\w{6,18}",message = "邮箱为数字和英文的组合最多不能超过18位")
    private String email;

    @Pattern(regexp = "\\d{6,9}",message = "qq为6到9位的数字")
    private String qq;

    @Pattern(regexp = "([\\u4e00-\\u9fa5]|\\w){6,18}",message = "工作单位为数字和英文组成最多8位")
    private String company;

    @Pattern(regexp = "([\\u4e00-\\u9fa5]|\\w){6,18}",message = "地址为数字和英文组成最多8位")
    private String address;

    @Pattern(regexp = "\\d{3,6}",message = "邮编为3到6位的数字")
    private String postcode;
}
