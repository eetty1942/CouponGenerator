package com.coupon.service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyNameAliases;
import org.springframework.stereotype.Service;

import com.coupon.domain.BaseResponse;
import com.coupon.domain.Coupon;
import com.coupon.domain.StandardResponseHeader;
import com.coupon.mapper.CouponMapper;

@Service
public class CouponGenerateServiceImpl implements CouponGenerateService{

	
	@Autowired
    private CouponMapper couponMapper;
	
	@Override
	public List<Coupon> getList() {
		return couponMapper.selectCouponList();
	}
	
	@Override
	public List<Coupon> getPagingList(int page, int itemsPerPage) {
		
		page = (page - 1)*itemsPerPage;
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("page", page);
		hashMap.put("itemsPerPage", itemsPerPage);

		
		return couponMapper.pagingCouponList(hashMap);
	}


	
	@Override
	public Coupon generateCoupon(String email) {
		
	
		String couponKey = "";
		Coupon coupon = new Coupon();
		//couponKey = generateKey();
		couponKey = generateKeyUseEmail(email);
		coupon.setEmail(email);
    		coupon.setCouponCode(couponKey);		

			
		return coupon;
	}

	@Override	
	public List<Coupon> isRegistedEmail(String email) {
		return couponMapper.checkRegistedEmail(email); 
	}
	@Override	
	public Boolean isRegistedCoupon(String coupon) {		
		return couponMapper.checkRegistedCoupon(coupon);
	}
	
	/**
	 * 
	 * 앞 8자리는 난수로 생성 **** ****
	 * 뒤 8자리는 앞 4자리, 뒤 4자리로 나누어 코드화 한다.
	 *앞4자리는 이메일의 아이디부분 아스키코드 변환 후 전체의 합 + 2000 (4자리가 안될 경우 고) 한뒤 16진수 문자열로 파싱 후 앞 4자리 저장 
	 * 뒤4자리는 이메일의 도메인 .com 혹은 .net 등의 앞부분의 곱 + 2000(4자리가 안될 경우 고) 한뒤 16진수 문자열로 파싱 후 앞 4자리 저장 
	 * 
	 * 이메일 아이디 + 도메인은 고유값으로 이를 코드화하면 고유값이 생성되어 중복 방지 
	 * @param email
	 * @return
	 */
	private static String generateKeyUseEmail(String email) {

        
        int idxMailId = email.indexOf("@"); 
        int idxMailDomain = email.indexOf("."); 
        String mailId = email.substring(0, idxMailId);
        String mailDomain = email.substring(idxMailId+1, idxMailDomain);
        String couponCode ="";
        String thirdKeyCode = "";
        String fourthKeyCode="";
        int thirdKey = 0;
        int fourthKey = 0;
        Random rnd = new Random();
	    StringBuffer buf = new StringBuffer();
		for(int i = 0; i < 8; i++){
	        if(rnd.nextBoolean()){
	            buf.append((char)((int)(rnd.nextInt(26))+65));
	            
	        }else{
	            buf.append((rnd.nextInt(9)));
	        }
	        //if(i==3 || i==8 || i==13) buf.append("-");
	    
	    }
	    couponCode = buf.toString();
        for(int i = 0; i < mailId.length(); i++){
            thirdKey += Math.pow((int) mailId.substring(i, i+1).charAt(0),2);
            System.out.println("thirdkey : " + thirdKey);

            
        }
        for(int i = 0; i < mailDomain.length(); i++){
            fourthKey =(int) (fourthKey * Math.pow((int) (mailDomain.substring(i, i+1).charAt(0)),2));
            System.out.println("fourthKey : " + thirdKey);
            
        }
        thirdKeyCode = Integer.toHexString(thirdKey).substring(0, 4);
        System.out.println("thirdkeyResult : " + thirdKeyCode);
        fourthKeyCode = Integer.toHexString(fourthKey).substring(0, 4);
        System.out.println("fourthkeyResult : " + fourthKeyCode);
		couponCode = couponCode+thirdKeyCode+fourthKeyCode;
	    System.out.println("couponCode : " + couponCode);
       
        return couponCode;
    }
	
	private static String generateKey() {
		
		Random rnd = new Random();
	    StringBuffer buf = new StringBuffer();
		for(int i = 0; i < 16; i++){
	        if(rnd.nextBoolean()){
	            buf.append((char)((int)(rnd.nextInt(26))+65));
	            
	        }else{
	            buf.append((rnd.nextInt(9)));
	        }
	        //if(i==3 || i==8 || i==13) buf.append("-");
	    
	    }
	    String couponCode = buf.toString();
	    System.out.println("couponCode : " + couponCode);
       
        return couponCode;
    }
	

	
}
