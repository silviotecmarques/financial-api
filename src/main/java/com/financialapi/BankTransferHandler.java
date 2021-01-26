package com.financialapi;

import com.financialapi.csv.CsvGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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

	@Autowired
	CsvGenerator csvGenerator;

	public Mono<ServerResponse> downloadReportCSV(ServerRequest request) {
		String fileName = String.format("%s.csv", RandomStringUtils.randomAlphabetic(10));

		String document = request.pathVariable("document");

		return ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
				.body(service.findByDocument(document)
						.collectList()
						.flatMap(csvGenerator::generate)
						.flatMap(inputStream -> {
							Resource resource = new InputStreamResource(inputStream);
							return Mono.just(resource);
						}), Resource.class);
	}
	
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

	public Mono<ServerResponse> findByStatus(ServerRequest request){
		String status = request.pathVariable("status");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findByStatus(status), BankTransfer.class);
	}

}