package com.example.demo.service;

import java.util.Map;

public interface UrlShorteningService {
	
	String getOriginUrl(String shortUrl, Map<String, UrlShorteningVO> shortUrlMap);
	
	UrlShorteningVO getUrlShorteningData(String originUrl, Map<String, UrlShorteningVO> originUrlMap, Map<String, UrlShorteningVO> shortUrlMap);

}
