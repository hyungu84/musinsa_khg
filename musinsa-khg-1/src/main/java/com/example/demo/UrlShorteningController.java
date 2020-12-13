package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UrlShorteningService;
import com.example.demo.service.UrlShorteningVO;

/**
 * @Class Name : UrlShorteningController.java
 * @Description : UrlShortening Controller Class
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020.12.12           	최초생성
 *
 * @author khg
 * @since 2020. 12.12
 * @version 1.0
 * @see
 *
 */

@Controller
public class UrlShorteningController {
	
	@Autowired
	private UrlShorteningService urlShorteningService;
	
	private Map<String, UrlShorteningVO> SHORT_URL_KEY_MAP = new HashMap<String, UrlShorteningVO>();
	// 중복 된 originUrl이 있는지 확인용
	private Map<String, UrlShorteningVO> ORIGIN_URL_KEY_MAP = new HashMap<String, UrlShorteningVO>();
	
	@RequestMapping(value = "/")
	public String urlShorteningRegisterForm(HttpServletResponse response) throws Exception {
		return "urlShorteningRegister";
	}
	
	@RequestMapping(value = "/{shortUrl}")
	public String moveShorteningUrl(@PathVariable("shortUrl") String shortUrl, HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 짧은 URL로 등록 된 데이터가 없다면 없는 화면으로
		if (!SHORT_URL_KEY_MAP.containsKey(shortUrl)) {
			return "noUrlPage";
		}

		// 짧은 URL로 인입 시 USE_CNT를 UPDATE
		// 짧은 URL로 인입 시 원URL 조회 해서 redirect
		String originUrl = urlShorteningService.getOriginUrl(shortUrl, SHORT_URL_KEY_MAP);

		return "redirect:".concat(originUrl);
	}
	
	@RequestMapping(value = "/addOriginUrl")
	public String addOriginUrl(HttpServletRequest request, Model model) throws Exception {
		
		String originUrl = request.getParameter("originUrl");
		
		// originUrl http가 없으면 앞에 생성
		if (!originUrl.contains("http")) {
			originUrl = "http://".concat(originUrl);
		}

		UrlShorteningVO resultData = urlShorteningService.getUrlShorteningData(originUrl, ORIGIN_URL_KEY_MAP, SHORT_URL_KEY_MAP);
		model.addAttribute("returnData", resultData);
		
		return "urlShorteningResult";
	}

}
