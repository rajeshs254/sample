package com.assignment.demo.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
/**
 * @author code.factory
 *
 */
@SuppressWarnings("deprecation")
@Configuration
public class AppConfig {
@SuppressWarnings("deprecation")
@Bean
 public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
  PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
  ppc.setLocation(new ClassPathResource("application.properties"));
  ppc.setIgnoreUnresolvablePlaceholders(true);
  return ppc;
 }
}