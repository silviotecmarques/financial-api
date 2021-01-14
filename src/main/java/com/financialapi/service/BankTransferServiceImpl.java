package com.financialapi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.financialapi.document.BankTransfer;
import com.financialapi.repository.BankTransferRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BankTransferServiceImpl implements BankTransferService {

	@Autowired
	BankTransferRepository btr;
	
	@Override
	public Flux<BankTransfer> findAll() {
		return btr.findAll();
	}

	@Override
	public Mono<BankTransfer> findById(String id) {
		return btr.findById(id);
	}

	@Override
	public Mono<BankTransfer> save(BankTransfer bankTransfer) {
		return btr.save(bankTransfer);
	}

}
