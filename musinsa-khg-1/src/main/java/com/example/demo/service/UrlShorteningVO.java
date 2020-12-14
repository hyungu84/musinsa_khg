package com.example.demo.service;

/**
 * @Class Name : UrlShorteningVO.java
 * @Description : UrlShorteningVO Class
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020.12.12           최초생성
 *
 * @author khg
 * @since 2020.12.12
 * @version 1.0
 * @see
 *
 */
public class UrlShorteningVO {
	
	/** 실제 URL */
	private String originalUrl;
	
	/** 짧은 URL */
	private String shortUrl;
	
	/** 사용수 */
	private long useCnt;

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public long getUseCnt() {
		return useCnt;
	}

	public void setUseCnt(long useCnt) {
		this.useCnt = useCnt;
	}

}
