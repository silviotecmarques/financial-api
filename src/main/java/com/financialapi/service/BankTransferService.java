package com.financialapi.service;

import com.financialapi.document.BankTransfer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankTransferService {

	Flux<BankTransfer> findAll();
	Mono<BankTransfer> findById(String id);
	Mono<BankTransfer> save(BankTransfer bankTransfer);
	
}
