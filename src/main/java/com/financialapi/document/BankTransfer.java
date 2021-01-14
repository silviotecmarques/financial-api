package com.financialapi.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BankTransfer {
	
	
	public BankTransfer(String id, String value, String beneficiary, String bank, String agency, String account,
			String document, String status, String processingdate) {
		super();
		this.id = id;
		this.value = value;
		this.beneficiary = beneficiary;
		this.bank = bank;
		this.agency = agency;
		this.account = account;
		this.document = document;
		this.status = status;
		this.processingdate = processingdate;
	}
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
	

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProcessingdate() {
		return processingdate;
	}
	public void setProcessingdate(String processingdate) {
		this.processingdate = processingdate;
	}
	
}