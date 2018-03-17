package com.coupon.mapper;

import java.util.List;

import com.coupon.domain.Coupon;

public interface CouponMapper {
	
	//생성 쿠폰 입력
	public void couponInsert(Coupon coupon)throws Exception;

	//전체 등록된 쿠폰 출력 
	public List<Coupon>couponList()throws Exception; 
	
	//존재하는 이메일 확인 
	public List<Coupon>couponExist(String email)throws Exception;

}
