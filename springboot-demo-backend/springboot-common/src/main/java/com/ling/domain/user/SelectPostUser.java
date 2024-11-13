package com.ling.domain.user;

import com.ling.common.PageRequest;
import lombok.Data;

@Data
public class SelectPostUser extends PageRequest {

    private String username;

    private Long sex;

    private String phone;

    private String address;
}
