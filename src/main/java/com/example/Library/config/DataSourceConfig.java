package com.example.Library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class DataSourceConfig {

    @Autowired
    Environment env;

//    @Bean
//    public DataSource mysqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        return dataSource;
//    }

    /**
     * @usage Autowire this in your JPA Repositories using
     * @Autowired JdbcTemplate mysqlJdbcTemplate;
     */
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(mysqlDataSource());
//    }

//    @Bean
//    public FilterRegistrationBean hiddenHttpMethodFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HiddenHttpMethodFilter());
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public FreeMarkerViewResolver freemarkerViewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(true);
//        resolver.setPrefix("");
//        resolver.setSuffix(".ftl");
//        return resolver;
//    }
//
//    @Bean
//    public FreeMarkerConfigurer freemarkerConfig() {
//        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//        freeMarkerConfigurer.setTemplateLoaderPath("resources/templates");
//        return freeMarkerConfigurer;
//    }
}
