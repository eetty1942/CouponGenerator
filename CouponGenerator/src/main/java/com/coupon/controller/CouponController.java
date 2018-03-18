package com.coupon.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.coupon.domain.BaseResponse;
import com.coupon.domain.Coupon;
import com.coupon.domain.StandardResponseHeader;
import com.coupon.mapper.CouponMapper;
import com.coupon.service.CouponGenerateService;

@RestController
public class CouponController {
   
	@Autowired
    private CouponMapper couponMapper;
	@Autowired
	private CouponGenerateService couponGenSrvc;
	
	
	
	@GetMapping("/coupon/checkRegisterd/email")
	public List<Coupon> checkExistEmail(String email) {
        List<Coupon> existCoupon = couponGenSrvc.isRegistedEmail(email);
        return existCoupon;
    }

	@GetMapping("/coupon/checkRegisterd/coupon")
	public List<Coupon> checkExistCoupon(String coupon) {
        List<Coupon> existCoupon = couponGenSrvc.isRegistedCoupon(coupon);
        return existCoupon;
    }

	@PostMapping("/coupon/write")
	public BaseResponse saveCoupon(Coupon coupon) {
		couponMapper.insertCoupon(coupon);
		return new BaseResponse(new StandardResponseHeader());
	}
	
	//페이지네이션 
	@RequestMapping("/coupon/list")
	public List<Coupon> pagenateCouponList(int i){
	
        List<Coupon> couponList = couponGenSrvc.getPagingList(i);
        return couponList;
    }



	
	

	

}
