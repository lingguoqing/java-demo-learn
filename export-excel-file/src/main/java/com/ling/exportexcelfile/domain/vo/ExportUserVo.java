package com.ling.exportexcelfile.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
public class ExportUserVo {

    /**
     * 订单编号
     */
    @ColumnWidth(30)
    @NumberFormat(pattern = "#")
    @ExcelProperty(value = "序号", index = 0)
    private String id;

    @ExcelProperty(value = "姓名", index = 1)
    private String username;

    @ExcelProperty(value = "性别", index = 2)
    private Long sex;

    @ExcelProperty(value = "手机号码", index = 3)
    private String phone;

    @ExcelProperty(value = "地址", index = 4)
    private String address;

}
