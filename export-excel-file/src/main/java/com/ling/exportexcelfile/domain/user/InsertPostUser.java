package com.ling.exportexcelfile.domain.user;

import lombok.Data;

@Data
public class InsertPostUser {

    private String username;

    private Long sex;

    private String phone;

    private String address;
}
