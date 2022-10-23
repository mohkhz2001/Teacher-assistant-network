package com.mohkhz.tanetwork.Model.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", length = 15)
    @NotNull
    @Size(min = 2, max = 15, message = "the role name length is invalid")
    private String RN;

//    @ManyToMany(mappedBy = "roles")
//    private Collection<User> users;

    public Role() {
    }

    public Role(Long id, String RN) {
        this.id = id;
        this.RN = RN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRN() {
        return RN;
    }

    public void setRN(String RN) {
        this.RN = RN;
    }
}
