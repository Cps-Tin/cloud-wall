package cn.cw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @desc 使用通用Mapper
 * @author _Cps
 * @create 2019-02-14 10:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")//使用通用的Mapper需要添加一些注解，并且自定义Mapper继承通用Mapper
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "createDate")
    private Date createDate;


    @Transient  //剔除该字段的映射
    private String imageCode;


    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", createDate=" + createDate +
                ", imageCode=" + imageCode +
                '}';
    }

}
