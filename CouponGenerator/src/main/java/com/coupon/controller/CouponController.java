package com.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.domain.Coupon;
import com.coupon.mapper.CouponMapper;

@RestController
public class CouponController {
   
	@Autowired
    private CouponMapper couponMapper;

	//전체 리스트 출력 
	@RequestMapping("/coupon")
	public List<Coupon> coupon() throws Exception{
        List<Coupon> coupon = couponMapper.couponList();
        return coupon;
    }

	

}
