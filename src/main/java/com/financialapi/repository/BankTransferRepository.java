package com.financialapi.repository;

import com.financialapi.enums.BankTransferStatusEnum;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.financialapi.document.BankTransfer;
import reactor.core.publisher.Flux;

public interface BankTransferRepository extends ReactiveMongoRepository<BankTransfer, String> {

    Flux<BankTransfer> findByDocument(String document);
    Flux<BankTransfer> findByStatus(BankTransferStatusEnum status);
}