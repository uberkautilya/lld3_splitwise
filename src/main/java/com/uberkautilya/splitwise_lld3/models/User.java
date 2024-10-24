package com.uberkautilya.splitwise_lld3.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "users")
public class User extends BaseEntity {
    String name;
    String phoneNumber;
    String email;
}
