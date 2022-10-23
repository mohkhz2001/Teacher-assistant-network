package com.mohkhz.tanetwork.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SId", length = 9, nullable = false, insertable = true, updatable = false , unique = true)
    @NotNull
    @NotBlank
    @Size(max = 9, min = 8, message = "the student id size is invalid...")
    private Long studentId;

    @Column(name = "full_name", insertable = true, updatable = true, length = 100)
    @NotNull
    @NotBlank
    @Size(max = 100, min = 2, message = "the name size is invalid...")
    private String fullName;

    @Column(name = "phone_number", nullable = false, insertable = true, updatable = true , unique = true)
    @NotBlank
    @NotNull
    private String phoneNumber;

    @Column(name = "password", nullable = false, insertable = true, updatable = false)
    @NotNull
    @JsonIgnore
    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;

    public User() {
    }

    public User(Long id, Long studentId, String fullName, String phoneNumber, String password, Collection<Role> roles) {
        this.id = id;
        this.studentId = studentId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
