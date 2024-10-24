package com.uberkautilya.splitwise_lld3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "groups")
@Getter
@Setter
public class Group extends BaseEntity {
    String name;
    @ManyToMany
    List<User> members;
    @ManyToOne
    User admin;
    @OneToMany(mappedBy = "group")
    List<Expense> expenses;
}
