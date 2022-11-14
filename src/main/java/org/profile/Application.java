package org.profile;

import org.glassfish.jersey.server.ResourceConfig;
import org.profile.controller.JaxRsController;
import org.profile.listener.MyListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContextListener;

/**
 * Hello world!
 *
 */
@EnableSwagger2
@SpringBootApplication
public class Application
{
    @Bean
    ResourceConfig resourceConfig() {
        return new ResourceConfig().packages("org.profile.controller").register(JaxRsController.class);
    }

    @Bean
    public ServletRegistrationBean customServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(), "/servlet");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> customListenerBean() {
        ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<>();
        bean.setListener(new MyListener());
        return bean;
    }
    @Bean
    public Docket docketApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/path/*"))
                .apis(RequestHandlerSelectors.basePackage("org.profile"))
                .build();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(Application.class);
    }
}
