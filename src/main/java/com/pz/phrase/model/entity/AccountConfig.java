package com.pz.phrase.model.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "TMS_ACCOUNT_CONFIG")
@DynamicUpdate
public class AccountConfig {

    @Id
    @Column(name = "CODE", nullable = false)
    @NotNull
    private String code;

    @Column(name = "USER_NAME", nullable = false)
    @NotNull
    private String userName;

    @Column(name = "PASS_WORD", nullable = false)
    @NotNull
    private String password;

    @Version
    private Integer version;

    public AccountConfig() {
    }

    public AccountConfig(String code, String userName, String password) {
        this.code = code;
        this.userName = userName;
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountConfig that = (AccountConfig) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "AccountConfig{" +
                "code='" + code + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
