package com.nisum.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class UserModel {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created")
    @CreatedDate
    private LocalDate created;

    @Column(name = "modified")
    @LastModifiedDate
    private LocalDate modified;

    @Column(name = "last_login")
    private LocalDate lastLogin;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private List<PhoneModel> phone;

}
