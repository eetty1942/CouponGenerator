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

@ControllerAdvice
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
	
	/*@GetMapping("/")
	public ModelAndView main() {
        List<Coupon> couponList = couponGenSrvc.getList();
        
        //return couponList;
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("list", "test");
        view.addObject(couponList);
        return view;
    }*/
	
	/*
	@PostMapping("/coupon/write")
	public String makeCoupon(String email) {
		
		Coupon coupon = couponGenSrvc.generateCoupon(email);
		couponGenSrvc.saveCoupon(coupon);
		
		return "redirect:/coupon";
	}
	*/
	/*
	@GetMapping("/writeForm")
	public ModelAndView selectWriteForm() {
        return new ModelAndView("writeForm");
    }*/
/*
	@GetMapping("/list")
	public List<Coupon> couponListForm() {
        List<Coupon> couponList = couponMapper.selectCouponList();
        //return new ModelAndView("couponList","list", couponList);
        return couponList;
    }*/
	
	
	@GetMapping("/coupon/checkRegisterd/email")
	public List<Coupon> checkExistEmail(String email) {
        List<Coupon> existCoupon = couponGenerateService.isRegistedEmail(email);
        return existCoupon;
    }

	@GetMapping("/coupon/checkRegisterd/coupon")
	public List<Coupon> checkExistCoupon(String coupon) {
        List<Coupon> existCoupon = couponGenerateService.isRegistedCoupon(coupon);
        return existCoupon;
    }
	
	//페이지네이션 
	@RequestMapping("/coupon/list")
	public List<Coupon> pagenateCouponList(int page, int itemsPerPage){
	
        List<Coupon> couponList = couponGenerateService.getPagingList(page, itemsPerPage);
        return couponList;
    }
	
	@PostMapping("/coupon/write")
	public BaseResponse saveCoupon(Coupon coupon) {
		couponMapper.insertCoupon(coupon);
		return new BaseResponse(new StandardResponseHeader());
	}


}
