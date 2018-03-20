package com.coupon.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.coupon.domain.BaseResponse;
import com.coupon.domain.Coupon;

public interface CouponMapper {
	
	public List<Coupon> selectCouponList();
	
	public List<Coupon> pagingCouponList(HashMap<String, Object> hashMap);
	
	public List<Coupon> checkRegistedEmail(String email);
	
	public Boolean checkRegistedCoupon(String couponCode);
	
	public void insertCoupon(Coupon coupon);
	
	

	

}
