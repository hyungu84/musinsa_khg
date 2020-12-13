package com.example.demo.service.impl;

import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.example.demo.service.UrlShorteningService;
import com.example.demo.service.UrlShorteningVO;

/**
 * @Class Name : UrlShorteningServiceImpl.java
 * @Description : UrlShortening Business Implement Class
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

@Service
public class UrlShorteningServiceImpl implements UrlShorteningService {
	
	@Override
	public String getOriginUrl(String shortUrl, Map<String, UrlShorteningVO> shortUrlMap) {
		
		String originUrl = shortUrlMap.get(shortUrl).getOriginUrl();
		long useCnt = shortUrlMap.get(shortUrl).getUseCnt();

		UrlShorteningVO urlShorteningVO = new UrlShorteningVO();
		urlShorteningVO.setOriginUrl(originUrl);
		urlShorteningVO.setShortUrl(shortUrl);
		urlShorteningVO.setUseCnt(++useCnt);

		shortUrlMap.put(shortUrl, urlShorteningVO);
		
		return originUrl;
		
	}
	
	@Override
	public UrlShorteningVO getUrlShorteningData(String originUrl, Map<String, UrlShorteningVO> originUrlMap, Map<String, UrlShorteningVO> shortUrlMap) {
		
		// ORIGIN_URL_KEY_MAP에 originUrl이 있으면 바로 리턴
		if(originUrlMap.get(originUrl) != null){
			
			UrlShorteningVO resultData = new UrlShorteningVO();
			resultData.setOriginUrl(originUrl);
			resultData.setShortUrl(originUrlMap.get(originUrl).getShortUrl());
			
			return resultData;
		}
		
		// 짧은 URL 랜덤함수로 생성
		String shortUrl = getShortUrl(shortUrlMap);

		UrlShorteningVO resultData = new UrlShorteningVO();
		resultData.setOriginUrl(originUrl);
		resultData.setShortUrl(shortUrl);
		
		shortUrlMap.put(shortUrl,resultData);
		originUrlMap.put(originUrl,resultData);
		
		return resultData;
		
	}
	
	private String getShortUrl(Map<String, UrlShorteningVO> shortUrlMap) {
		
		String shortUrl = RandomStringUtils.randomAlphabetic(8);
//		System.out.println("shortUrl : " + shortUrl);

		// 짧은 URL이 혹시 동일한 경우 처리
		int loopCnt = 0;
		while (shortUrlMap.containsKey(shortUrl)) {
			loopCnt++;
			shortUrl = RandomStringUtils.randomAlphabetic(8);
			
//			System.out.println("shortUrl : " + shortUrl);

			// 무한loop 방어로직
			if (loopCnt == 10) {
				break;
		    }
		}
		
		return shortUrl;
		
	}

}
