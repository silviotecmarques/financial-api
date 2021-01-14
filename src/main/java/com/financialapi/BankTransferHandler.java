package com.financialapi;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.financialapi.document.BankTransfer;
import com.financialapi.service.BankTransferService;

import reactor.core.publisher.Mono;

import static  org.springframework.web.reactive.function.BodyInserters.fromPublisher ;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@Component
public class BankTransferHandler {
	
	@Autowired
	BankTransferService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), BankTransfer.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id), BankTransfer.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<BankTransfer> banktransfer = request.bodyToMono(BankTransfer.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(banktransfer.flatMap(service::save), BankTransfer.class));

}
	}