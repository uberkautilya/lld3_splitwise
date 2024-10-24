package com.uberkautilya.splitwise_lld3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "user_groups")
@Getter
@Setter
public class Group extends BaseEntity {
    private String name;
    @ManyToMany
    private List<User> members;
    @ManyToOne
    private User admin;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}
