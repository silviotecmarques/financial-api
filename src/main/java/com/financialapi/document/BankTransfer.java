package com.financialapi.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


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
	private String status;
	private String processingdate;
	
}