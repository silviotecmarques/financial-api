package com.financialapi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.financialapi.document.BankTransfer;
import com.financialapi.repository.BankTransferRepository;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankTransferServiceImpl implements BankTransferService {

	@Autowired
	BankTransferRepository bankTransferRepository;
	
	@Override
	public Flux<BankTransfer> findAll() {
		return bankTransferRepository.findAll();
	}

	@Override
	public Mono<BankTransfer> findById(String id) {
		return bankTransferRepository.findById(id);
	}

	@Override
	public Mono<BankTransfer> save(BankTransfer bankTransfer) {
		return bankTransferRepository.save(bankTransfer);
	}

	@Override
	public Flux<BankTransfer> findByDocument(String document) {
		return bankTransferRepository.findByDocument(document);
	}

}
