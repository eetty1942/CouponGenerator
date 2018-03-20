package com.coupon.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
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

@ControllerAdvice("com.maple")
@RestController
public class CouponController {
   
	@Autowired
    private CouponMapper couponMapper;
	@Autowired
	private CouponGenerateService couponGenerateService;
	

	/*@GetMapping("/coupon")
	public List<Coupon> selectCouponList() {
        List<Coupon> couponList = couponGenSrvc.getList();
        
        return couponList;
    }*/
	
	
	
	@GetMapping("/coupon/checkRegisterd/email")
	public List<Coupon> checkExistEmail(String email) {
        List<Coupon> existCoupon = couponGenerateService.isRegistedEmail(email);
        return existCoupon;
    }

	@GetMapping("/coupon/checkRegisterd/coupon")
	public Boolean checkExistCoupon(String coupon) {
       
        return  couponGenerateService.isRegistedCoupon(coupon);
    }
	
	//페이지네이션 
	@RequestMapping("/coupon/list")
	public List<Coupon> pagenateCoponList(int page, int itemsPerPage) {
	
        List<Coupon> couponList = couponGenerateService.getPagingList(page, itemsPerPage);
        return couponList;
    }
	
	@PostMapping("/coupon/write")
	public BaseResponse saveCoupon(Coupon coupon) {
		couponMapper.insertCoupon(coupon);
		return new BaseResponse(new StandardResponseHeader());
	}
	

}
