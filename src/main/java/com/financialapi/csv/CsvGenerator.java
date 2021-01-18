package com.financialapi.csv;

import com.financialapi.document.BankTransfer;
import reactor.core.publisher.Mono;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface CsvGenerator {

    Mono<ByteArrayInputStream> generate(List<BankTransfer> objects);
}