package com.coupon.service;

import java.util.List;

import com.coupon.domain.BaseResponse;
import com.coupon.domain.Coupon;

public interface CouponGenerateService {
	
	/**
	 * @return
	 */
	List<Coupon> getList();

	List<Coupon> getPagingList(int i);
	
	List<Coupon> isRegistedCoupon(String coupon);
	
	List<Coupon> isRegistedEmail(String emain);

	public Coupon generateCoupon(String email);	

}
