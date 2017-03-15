
package com.meraki.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 7406695508037970942L;

    private Integer roleid;
    private String rolename;
    private Set<User> users = new HashSet<User>(0);

    public Role() {
    }

    public Role(String rolename, int userid) {
        this.rolename = rolename;
    }

    public Role(String rolename, int userid, String email, Date expDate, String firstName, Boolean isactive, Boolean isnonexpired, Boolean isnonlocked, String lastName, String password, String phone, Date regdate, String username, Set<User> users) {
        this.rolename = rolename;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid", unique = true, nullable = false)
    public Integer getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Column(name = "rolename", nullable = false, length = 45)
    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
