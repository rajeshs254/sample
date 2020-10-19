package com.assignment.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
/**
 * @author code.factory
 *
 */
@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {
}

