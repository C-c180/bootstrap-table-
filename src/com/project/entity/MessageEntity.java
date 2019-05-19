package com.project.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "sms")
@Data
public class MessageEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String username;

    @NotEmpty(message = "发送者不能为空")
    private String sender;

    @Pattern(regexp = "([\\u4e00-\\u9fa5]|\\w){5,100}",message = "消息内容为中文或英文醉倒不能超过100")
    private String message;

    private String sendtime;

    private String isRead="未读";

    public MessageEntity() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        sendtime=simpleDateFormat.format(new Date());
    }
}
