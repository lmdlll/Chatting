package com.lmd.Client.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String passwd;
    private String brief;
}
