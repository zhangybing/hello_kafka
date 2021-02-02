package com.yibing.serializer;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author admin
 */
public class User implements Serializable {
    private String userName;
    private Integer high;
    private String like;

    public User() {
    }

    public User(String userName, Integer high, String like) {
        this.userName = userName;
        this.high = high;
        this.like = like;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", high=" + high +
                ", like='" + like + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(high, user.high) &&
                Objects.equals(like, user.like);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, high, like);
    }
}
