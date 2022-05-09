/*
 * Developed by: Luis Espinosa, be aware that this project
 * is part of my personal portfolio.
 */
package com.lsoftware.voting.config;

import org.springframework.context.annotation.Configuration;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

/**
 * The Class GatewayConfig.
 * 
 * @author Luis Espinosa
 */
@Configuration
public class GatewayConfig {
	
	/** The sliding window size. */
	@Value("${circuit-breaker.sliding-windows-size}")
	private int slidingWindowSize;

	/** The permitted number of calls in half open state. */
	@Value("${circuit-breaker.number-calls-in-half-open-state}")
	private int permittedNumberOfCallsInHalfOpenState;

	/** The failure rate threshold. */
	@Value("${circuit-breaker.failure-rate-threshold}")
	private float failureRateThreshold;

	/** The max total. */
	@Value("${circuit-breaker.wait-duration-open-state}")
	private long waitDurationInOpenState;

	
	/**
	 * My routes.
	 *
	 * @param routeLocatorBuilder the route locator builder
	 * @return the route locator
	 */
	@Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/info/**")
						.filters(f -> f
								.circuitBreaker(c -> c.setName("infoCircuit").setFallbackUri("/fallback/infoServiceFallback"))
								.rewritePath("/info/(?<path>.*)", "/$\\{path}"))
						.uri("lb://name-info"))
                .route(p ->p
                        .path("/votes/**")
                        .filters(f -> f
                        		.circuitBreaker(c -> c.setName("voteCircuit").setFallbackUri("/fallback/voteServiceFallback"))
                        		.rewritePath("/votes/(?<path>.*)", "/$\\{path}")
                        )
                        .uri("lb://name-votes"))
                .route(p ->p
                		.path("/results/**")
                        .filters(f -> f
                        		.circuitBreaker(c -> c.setName("resultsCircuit").setFallbackUri("/fallback/resultsServiceFallback"))
                        		.rewritePath("/results/(?<path>.*)", "/$\\{path}"))
                        .uri("lb://name-results"))
                .build();
    }
	
	
	/**
	 * Default customizer.
	 *
	 * @return the customizer
	 */
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.circuitBreakerConfig(
						//CircuitBreakerConfig.ofDefaults()
						CircuitBreakerConfig.custom()
						.slidingWindowSize(slidingWindowSize) // defines how many outcome calls has to be recorded when a circuit breaker is closed
						.permittedNumberOfCallsInHalfOpenState(permittedNumberOfCallsInHalfOpenState) //configure a number of permitted calls in the HALF_OPEN state. 
						.failureRateThreshold(failureRateThreshold) //responsible for configuring the failure rate threshold in percentage. If the failure rate is equal or greater than the threshold the circuit breaker is switched to open and starts short-circuiting calls.
						.waitDurationInOpenState(Duration.ofMillis(waitDurationInOpenState)) //how long the circuit should stay in the OPEN state without trying to process any request
						.build()
				)
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(8)).build())
				.build());
	}

}
