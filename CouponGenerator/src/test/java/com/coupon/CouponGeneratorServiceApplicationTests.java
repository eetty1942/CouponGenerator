package com.coupon;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.coupon.domain.Coupon;
import com.coupon.mapper.CouponMapper;

import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.SpringApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration(classes = CouponGeneratorServiceApplication.class)
@WebAppConfiguration
public class CouponGeneratorServiceApplicationTests {

	@Autowired
    private CouponMapper mapper;


	 
	 @Test
	 public void contextLoads() {
	 }
	 
	 @Test
	    public void testMapper() throws Exception{//작성
	        
	        Coupon coupon = new Coupon();
	        
	        //coupon.setEmail('eetty1942@naver.com');
	       // coupon.setCouponCode('1A2D-2S3D-1Q3R-ASG7');
	        //coupon.setRegistDate(now());
	        //c//oupon.setValidDate(now()+7);
	        //mapper.boardInsert(vo);
	        
	    }
	 
	 //@Test
	/* public void testConnection() throws Exception{ //작성
	     System.out.println("ds : "+ds);
         Connection con = ds.getConnection(); //ds(DataSource)에서 Connection을 얻어내고
	        
	        System.out.println("con : "+con); //확인 후
	        
	        con.close(); //close
	    }*/
}
