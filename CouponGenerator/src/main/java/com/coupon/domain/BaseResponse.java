package com.coupon.domain;

import lombok.Data;

@Data
public class BaseResponse {
	private StandardResponseHeader header;
	
	public BaseResponse() {
		this.header = new StandardResponseHeader();
	}
	
	public BaseResponse(Integer errorCode, String errorMessage) {
		this(new StandardResponseHeader(errorCode, errorMessage));
	}
	
	public BaseResponse(StandardResponseHeader header) {
		this.header = header;
	}
}
