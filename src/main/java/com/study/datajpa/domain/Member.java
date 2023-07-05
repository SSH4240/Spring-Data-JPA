package com.study.datajpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String username;
    @Embedded
    private Address address;

}
