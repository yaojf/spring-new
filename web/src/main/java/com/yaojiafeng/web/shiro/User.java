package com.yaojiafeng.web.shiro;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/6/12 下午8:32 $
 */
public class User {
    private String name;
    private String password;
    private Role role;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
