package com.lexue.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class UserList {

    private List<User> userList = new ArrayList<>();

}
