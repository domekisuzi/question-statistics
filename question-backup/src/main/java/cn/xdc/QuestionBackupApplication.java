package cn.xdc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.xdc.mapper")
public class QuestionBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionBackupApplication.class, args);
    }

}
