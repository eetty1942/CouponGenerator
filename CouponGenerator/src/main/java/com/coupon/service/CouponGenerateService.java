package com.coupon.service;

import java.util.List;

import com.coupon.domain.BaseResponse;
import com.coupon.domain.Coupon;

public interface CouponGenerateService {
	
	/**
	 * @return
	 */
	List<Coupon> getList();

	List<Coupon> getPgingList(int i);
	
	BaseResponse saveCoupon(Coupon coupon);
	
	
	public Coupon generateCoupon(String email);	

}
