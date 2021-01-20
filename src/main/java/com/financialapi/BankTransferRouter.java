package com.financialapi;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;




@Configuration
public class BankTransferRouter {

	@Bean
	public RouterFunction<ServerResponse> router(BankTransferHandler handler){
		return RouterFunctions
				.route(GET("/banktransfer").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/banktransfer/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/banktransfer").and(accept(MediaType.APPLICATION_JSON)), handler::save)
				.andRoute(GET("/banktransfer/report/document/{document}"), handler::downloadReportCSV);
	}
	
}
