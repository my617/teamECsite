package jp.co.internous.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import jp.co.internous.angular.model.domain.MstProduct;
import jp.co.internous.angular.model.mapper.MstProductMapper;
import jp.co.internous.angular.model.session.LoginSession;

@Controller
@RequestMapping("/angular/product")
public class ProductController {
	
	@Autowired
	MstProductMapper mstProductMapper;
	
	@Autowired
	LoginSession loginSession;
	
	Gson gson = new Gson();
	
	@RequestMapping("/{id}")
	public String index(@PathVariable("id") String productId, Model m) {
		
		m.addAttribute("loginSession", loginSession);
		
		MstProduct product = mstProductMapper.findProduct(productId);
		m.addAttribute("product", product);
		
		return "product_detail";
	}

}
