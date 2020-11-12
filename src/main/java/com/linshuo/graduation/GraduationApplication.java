package com.linshuo.graduation;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })
public class GraduationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduationApplication.class, args);
	}
	/**
	 * http重定向到https
	 * @return
	 */
	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(createHTTPConnector());
		return tomcat;
	}

	private Connector createHTTPConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		//同时启用http（8080）、https（443）两个端口
		connector.setScheme("http");
		connector.setSecure(false);
		connector.setPort(8080);
		connector.setRedirectPort(1998);
		return connector;
	}

}
