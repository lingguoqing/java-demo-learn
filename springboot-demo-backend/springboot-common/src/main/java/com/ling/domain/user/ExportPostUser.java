package com.ling.domain.user;

import com.ling.common.PageRequest;
import lombok.Data;

@Data
public class ExportPostUser extends PageRequest {

    private Long sex;
    private String phone;
}
