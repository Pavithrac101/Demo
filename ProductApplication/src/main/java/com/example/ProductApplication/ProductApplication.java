package com.example.ProductApplication;

import com.example.ProductApplication.filter.ProductFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	//bean configuration of filter
	@Bean
	public FilterRegistrationBean filterUrl()
	{
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean<>();

		//step 1 : location of filter
		filterRegistrationBean.setFilter(new ProductFilter());
		//step 2: intercepted url on which filter has to be applied
		filterRegistrationBean.addUrlPatterns("/prod/v1/getUser","/prod/v1/updateUser","/prod/v1/getAllUsers");
		return filterRegistrationBean;
	}
}
