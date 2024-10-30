package com.ling.exportexcelfile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ling.exportexcelfile.mapper")
public class ExportExcelFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExportExcelFileApplication.class, args);
    }

}
