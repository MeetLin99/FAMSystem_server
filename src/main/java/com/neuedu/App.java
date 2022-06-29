package com.neuedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.neuedu.fillter.CrosFilter;
/**
 * 这是SpringBoot本项目的启动类
 * @author 
 *
 */
@SpringBootApplication
@MapperScan("com.neuedu.mapper")
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

	/**
     * 配置跨域访问的过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean<CrosFilter> registerFilter(){
        FilterRegistrationBean<CrosFilter> bean = new FilterRegistrationBean<CrosFilter>();
        bean.addUrlPatterns("/*");
        bean.setFilter(new CrosFilter());
        return bean;
    }
}
