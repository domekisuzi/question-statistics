package cn.xdc.questionbackup;
/**
 * made by @domekisuzi at
 * 2024/7/10:18:39
 */


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;

public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/question_backup", "root", "123456")
                .globalConfig(builder -> builder
                        .author("domekisuzi")
                        .outputDir(Paths.get("D:\\java project\\question-backup") + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("cn.xdc")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                                .controller("controller")

                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                        .enableFileOverride()

                )

                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
