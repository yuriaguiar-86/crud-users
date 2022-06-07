package br.com.imepac.crud.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 220, nullable = false)
    private String name;

    @Column(length = 220, nullable = false, unique = true)
    private String email;

    @Column(length = 30, nullable = true)
    private String phone;

    @Column(length = 15, nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    //Constructor
    public UserEntity() {
        super();
    }

    public UserEntity(Long id, String name, String email, String phone, String cpf, LocalDate birth) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.birth = birth;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    //Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
