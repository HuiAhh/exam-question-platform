package com.huiahh.cartexam.generator;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

@Data
public class CodeGenerator {

    /**
     * 配置文件名
     */
    private final static String APP_PROPERTY = "application.properties";
    private String projectPath = System.getProperty("user.dir");
    /**
     * 公共包路径
     * 1
     */
    private String parentPackage = "com.huiahh.cartexam";
    /**
     * 模块名
     * 2
     */
    private String module = "generator";

    /**
     * 自定义模板位置
     */
    private String templatePath = "templates/mp/";
    private String controllerTemplate = templatePath + "controller.java";
    private String serviceTemplate = templatePath + "service.java";
    private String serviceImplTemplate = templatePath + "serviceImpl.java";
    private String mapperTemplate = templatePath + "mapper.java";


    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (ipt != null && !ipt.trim().isEmpty()) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    public void execute() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(scanner("Author"));    //设置作者
        gc.setOpen(false);  //生成后不打开文件
        gc.setActiveRecord(true);
        gc.setIdType(IdType.AUTO);
        gc.setServiceName("%sService");
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);
        gc.setSwagger2(true);   //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        mpg.setDataSource(dataSourceConfig());

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackage);
        pc.setModuleName(module);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        mpg.setCfg(cfg);



        // 配置自定义输出模板
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setXml(null);
        templateConfig.setService(serviceTemplate);
        templateConfig.setServiceImpl(serviceImplTemplate);
        templateConfig.setMapper(mapperTemplate);
        templateConfig.setController(controllerTemplate);
        mpg.setTemplate(templateConfig);

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("exam" + "_");
        mpg.setStrategy(strategy);


        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


    private static DataSourceConfig dataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();

        String resourcePath = System.getProperty("user.dir") + "/src/main/resources/" + APP_PROPERTY;
        try {
            InputStream inStream = new FileInputStream(new File(resourcePath));
            Properties prop = new Properties();
            prop.load(inStream);

            dsc.setUrl(prop.getProperty("spring.datasource.url"));
            dsc.setDriverName(prop.getProperty("spring.datasource.driver-class-name"));
            dsc.setUsername(prop.getProperty("spring.datasource.username"));
            dsc.setPassword(prop.getProperty("spring.datasource.password"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dsc;
    }

}