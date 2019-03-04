package com.dlmu.bbs.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "uuid")
    private String uuid;
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false, length = 100)
    private int age;
    @Column(length = 20)
    private String avatar;//头像路径
    private int qqNumber;
    @Column(length = 30)
    private String email;
    private int cellphone;
    private int authority;//
    //@Column(nullable = false, length = 20)
    private String identityCard;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getQqNumber() {
        return qqNumber;
    }

    public void setQqnumber(int qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQqNumber(int qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
}
