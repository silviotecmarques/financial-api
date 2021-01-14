package com.financialapi.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.financialapi.document.BankTransfer;

public interface BankTransferRepository extends ReactiveMongoRepository<BankTransfer, String> {

}
