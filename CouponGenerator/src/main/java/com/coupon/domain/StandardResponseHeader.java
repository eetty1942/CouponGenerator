package com.coupon.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class StandardResponseHeader {
	public static final int RESULTCODE_SUCCESS = 0;
	public static final String RESULT_SUCCESS = "SUCCESS";
	
	private Boolean successful = true;
	private Integer resultCode;
	private String resultMessage;
	private Integer totalCount;

	@JsonInclude(Include.NON_NULL)
	private Object invalidParameters;

	public StandardResponseHeader() {
		this.setResultCode(RESULTCODE_SUCCESS);
		this.setResultMessage(RESULT_SUCCESS);
	}

	public StandardResponseHeader(Integer resultCode, String resultMessage) {
		this.setResultCode(resultCode);
		this.setResultMessage(resultMessage);
		this.setIsSuccessful(false);
	}
	
	public StandardResponseHeader(Integer resultCode, String resultMessage, Object data) {
		this.setResultCode(resultCode);
		this.setResultMessage(resultMessage);
		this.setIsSuccessful(false);
		this.setInvalidParameters(data);
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Boolean getIsSuccessful() {
		return successful;
	}

	public void setIsSuccessful(Boolean isSuccessful) {
		this.successful = isSuccessful;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	public Object getInvalidParameters() {
		return invalidParameters;
	}

	public void setInvalidParameters(Object invalidParameters) {
		this.invalidParameters = invalidParameters;
	}
	
}