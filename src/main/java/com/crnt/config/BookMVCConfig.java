package com.crnt.config;

import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.crnt"})
@EnableWebMvc
public class BookMVCConfig implements WebMvcConfigurer{
	
	@Bean
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		SimpleMappingExceptionResolver exceptionResolver=new SimpleMappingExceptionResolver();
		exceptionResolver.setDefaultErrorView("error");
		
		Properties properties= new Properties();
		properties.put("java.lang.Exception", "error-book");
		exceptionResolver.setExceptionMappings(properties);

		resolvers.add(exceptionResolver);
		WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);
	}
	
	

}
