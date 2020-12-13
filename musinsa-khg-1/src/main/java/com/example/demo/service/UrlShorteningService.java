package com.example.demo.service;

import java.util.Map;

/**
 * @Class Name : UrlShorteningService.java
 * @Description : UrlShorteningService Class
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
public interface UrlShorteningService {
	
	/**
	 * 원 URL을 가져온다.
	 * @param shortUrl, shortUrlMap
	 * @return String
	 */
	String getOriginUrl(String shortUrl, Map<String, UrlShorteningVO> shortUrlMap);
	
	/**
	 * 저장 된 URL DATA를 가져온다.
	 * @param originUrl, originUrlMap, shortUrlMap
	 * @return UrlShorteningVO
	 */
	UrlShorteningVO getUrlShorteningData(String originUrl, Map<String, UrlShorteningVO> originUrlMap, Map<String, UrlShorteningVO> shortUrlMap);

}
