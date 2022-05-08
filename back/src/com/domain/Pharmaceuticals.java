package com.domain;

public class Pharmaceuticals {
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSpecifications() {
		return Specifications;
	}
	public void setSpecifications(String specifications) {
		Specifications = specifications;
	}
	public String getEnterprises() {
		return enterprises;
	}
	public void setEnterprises(String enterprises) {
		this.enterprises = enterprises;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}

	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Pharmaceuticals(){}
	public Pharmaceuticals(String alt, String number, String specifications, String enterprises, String business,
			String introduction, String src, String urlimg) {
		super();
		this.alt = alt;
		this.number = number;
		Specifications = specifications;
		this.enterprises = enterprises;
		this.business = business;
		Introduction = introduction;
		this.src = src;
		this.urlimg = urlimg;
	}
	public String alt;// 产品名称
	public String number;// 批准文号
	public String Specifications;// 规格
	public String enterprises;// 生产企业
	public String business;// 经营企业
	public String Introduction;// 产品简介
	public String src;
	public String urlimg;
	public String usemethod;
	public String components;
	public String advantage;
	public String getUsemethod() {
		return usemethod;
	}
	public void setUsemethod(String usemethod) {
		this.usemethod = usemethod;
	}
	public String getComponents() {
		return components;
	}
	public void setComponents(String components) {
		this.components = components;
	}
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	public String getUrlimg() {
		return urlimg;
	}
	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}

}
