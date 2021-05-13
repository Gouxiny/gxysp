package com.gouxy.sys.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{
	
	/**解决跨域问题**/
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
	
	@Bean
	public RequestContextListener requestContextListenerBean() {
		return new RequestContextListener();
	}
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
    
    
    /**添加拦截器 **/
    public void addInterceptors(InterceptorRegistry registry) {};
    
    /** 这里配置视图解析器 **/
    public void configureViewResolvers(ViewResolverRegistry registry) {};
    
    /** 配置内容裁决的一些选项 **/
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {};
    
    /** 视图跳转控制器 **/
    public void addViewControllers(ViewControllerRegistry registry) {};
    
    /** 静态资源处理 避免静态资源被拦截**/
    public void addResourceHandlers(ResourceHandlerRegistry registry) {};
    
    /** 默认静态资源处理器 **/
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {};
}
