package com.coupon;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.coupon.controller.CouponController;
import com.coupon.domain.Coupon;
import com.coupon.mapper.CouponMapper;
import com.coupon.service.CouponGenerateService;

import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.SpringApplicationConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CouponGeneratorServiceApplicationTests {

	  @Autowired
	    private TestRestTemplate restTemplate;

	    @MockBean
	    public CouponGenerateService couponGenerateService;

	    @Test
	    public void userRestTemplateTest() throws Exception {
	        /*Coupon coupon = new Coupon();
	        coupon.setEmail("test111@naver.com");
	        given(couponGenerateService.isRegistedEmail(coupon.getEmail()).willReturn("test111@naver.com");
	        ResponseEntity<Coupon> couponEntity = this.restTemplate.getForEntity("/coupon/checkRegisterd/email", Coupon.class, 0);
	        Coupon body = couponEntity.getBody();
	        assertThat(body.getEmail()).isEqualTo("test111@naver.com");*/
	    }
}
