package cn.cw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author _Cps
 * @create 2019-02-14 10:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String userName;

    private String password;

    private Integer gender;

    //@JSONField(format = "yyyy-MM-dd HH:mm:ss")处理JSON格式日期问题
    //这里使用了JSONArray.toJSONStringWithDateFormat()处理日期问题，在Result类中
    private Date createDate;

    private String checkCode;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", createDate=" + createDate +
                ", checkCode=" + checkCode +
                '}';
    }

}
