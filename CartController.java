package jp.co.internous.angular.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.angular.model.domain.TblCart;
import jp.co.internous.angular.model.domain.dto.CartDto;
import jp.co.internous.angular.model.form.CartForm;
import jp.co.internous.angular.model.mapper.TblCartMapper;
import jp.co.internous.angular.model.session.LoginSession;

@Controller
@RequestMapping("/angular/cart")
public class CartController {
	
	@Autowired
	TblCartMapper tblCartMapper;
	
	@Autowired
	LoginSession loginSession;
	
	Gson gson = new Gson();

	@RequestMapping("/")
	public String index(Model m) {
		int userId = loginSession.getLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		List<CartDto> carts = tblCartMapper.findByUserId(userId);
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("carts", carts);
		
		return "cart";
	}
	
	@RequestMapping("/add")
	public String addCart(CartForm f, Model m) {
		
		int userId = loginSession.getLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		f.setUserId(userId);
		
		TblCart cart = new TblCart(f);
		int result = 0;
		if(tblCartMapper.findCountByUserIdAndProuductId(userId, f.getProductId()) > 0) {
			result = tblCartMapper.update(cart);
		} else {
			result = tblCartMapper.insert(cart);
		}
		if(result > 0) {
			List<CartDto> carts = tblCartMapper.findByUserId(userId);
			m.addAttribute("loginSession",loginSession);
			m.addAttribute("carts",carts);
		}
		
		return "cart";
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@PostMapping("/delete")
	public boolean deleteCart(@RequestBody String checkedIdList) {
		int result = 0;
		
		Map<String, List<String>> map = gson.fromJson(checkedIdList, Map.class);
		List<String> checkedIds = map.get("checkedIdList");
		for(String id : checkedIds) {
			result += tblCartMapper.deleteById(Integer.parseInt(id));
		}
		
		return result > 0;
		
	}
	
}
