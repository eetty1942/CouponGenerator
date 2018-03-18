package com.coupon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.coupon.domain.BaseResponse;
import com.coupon.domain.Coupon;

public interface CouponMapper {
	
	public List<Coupon> selectCouponList();
	
	public List<Coupon> pagingCouponList(int page);
	
	public List<Coupon> checkRegistedEmail(String email);
	
	public List<Coupon> checkRegistedCoupon(String couponCode);
	
	public void insertCoupon(Coupon coupon);
	
	

	

}
