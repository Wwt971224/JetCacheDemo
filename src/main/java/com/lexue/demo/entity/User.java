package com.lexue.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class User implements Serializable {

    private Long userId;
    private String userName;

}
