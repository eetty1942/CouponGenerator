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

import com.coupon.domain.Coupon;
import com.coupon.mapper.CouponMapper;
import com.coupon.service.CouponGenerateService;

@RestController
public class CouponController {
   
	@Autowired
    private CouponMapper couponMapper;
	@Autowired
	private CouponGenerateService couponGenSrvc;
	
	
	/*@GetMapping("/coupon")
	public List<Coupon> selectCouponList() {
        List<Coupon> couponList = couponGenSrvc.getList();
        
        return couponList;
    }*/
	
	@GetMapping("/")
	public ModelAndView main() {
        List<Coupon> couponList = couponGenSrvc.getList();
        
        //return couponList;
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("list", "test");
        view.addObject(couponList);
        return view;
    }

	@GetMapping("/list")
	public ModelAndView couponListForm() {
        List<Coupon> couponList = couponMapper.selectCouponList();
        return new ModelAndView("couponList","list", couponList);
    }
	
	@GetMapping("/writeForm")
	public ModelAndView selectWriteForm() {
        return new ModelAndView("writeForm");
    }
	
	@GetMapping("/coupon/emailcheck")
	public Coupon checkExistEmail(String email) {
        Coupon existCoupon = couponMapper.checkRegistedEmail(email);
        return existCoupon;
    }
	
	@PostMapping("/coupon/write")
	public String makeCoupon(String email) {
		
		Coupon coupon = couponGenSrvc.generateCoupon(email);
		couponGenSrvc.saveCoupon(coupon);
		
		return "redirect:/coupon";
	}
	
	//페이지네이션 
	@RequestMapping("/coupon/list/")
	public ModelAndView pagenateCouponList(int i) throws Exception{
	
        List<Coupon> couponList = couponGenSrvc.getPgingList(i);
        return new ModelAndView("couponPagingList","list", couponList);
    }



	
	

	

}
