package com.example.demo.service;

public class UrlShorteningVO {
	
	/** 실제 URL */
	private String originUrl;
	
	/** 짧은 URL */
	private String shortUrl;
	
	/** 사용수 */
	private long useCnt;

	public String getOriginUrl() {
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
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
