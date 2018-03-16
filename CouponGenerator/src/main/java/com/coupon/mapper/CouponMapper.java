package com.coupon.mapper;

import java.util.List;

import com.coupon.domain.Coupon;

public interface CouponMapper {
	
	public void couponInsert(Coupon coupon)throws Exception;

	public List<Coupon>couponList()throws Exception; 
	
	public List<Coupon>couponExist()throws Exception;

}
