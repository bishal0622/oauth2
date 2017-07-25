package com.oauthdemo.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by bishal on 7/17/17.
 */
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer authId;
    String authority;

    public Authority() {
    }

    public Authority(Integer authId, String authority) {
        this.authId = authId;
        this.authority = authority;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authId=" + authId +
                ", authority='" + authority + '\'' +
                '}';
    }
}
