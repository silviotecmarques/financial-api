package com.financialapi.document;

import com.financialapi.constants.BankTransferStatusEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class BankTransfer {
	
	@Id
	private String id;
	private String value;
	private String beneficiary;
	private String bank;
	private String agency;
	private String account;
	private String document;
	private BankTransferStatusEnum status;
	private LocalDateTime processingdate;
	
}