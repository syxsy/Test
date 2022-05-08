package com.demo.health;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.domain.BMIManageInfo;
import com.domain.Pharmaceuticals;
import com.domain.PublicUsersInfo;

import java.io.IOException;
import java.util.ArrayList;
 
public class joUtil {
	
  public static String starturl="https://www.yaopinnet.com/";

    public static ArrayList<Pharmaceuticals> getPharmaceuticalslist(String sort) throws IOException{
    	ArrayList<Pharmaceuticals> Pharmaceuticalslist = new ArrayList<>();
    	
    	String url = null;
    	if(sort.endsWith("抗生素")) {
    		url = "https://www.yaopinnet.com/zhaoshang/kangshengsu.asp";
    	}else if(sort.endsWith("心脑血管")) {
    		url = "https://www.yaopinnet.com/zhaoshang/xinnaoxueguan.asp";
    	}else if(sort.endsWith("增强免疫力")) {
    		url = "https://www.yaopinnet.com/zhaoshang/bjp.asp?k=BJ0001";
    	}else if(sort.endsWith("降血糖")) {
    		url = "https://www.yaopinnet.com/zhaoshang/bjp.asp?k=BJ0003";
    	}else if(sort.endsWith("降血脂")) {
    		url = "https://www.yaopinnet.com/zhaoshang/bjp.asp?k=BJ0002";
    	}
   	 String alt,src,number,specifications,enterprises,business,introduction,urlimg;
       Document doc = Jsoup.connect(url) .timeout(60000).get();
       doc.html();
       Elements elements1=doc.getElementsByClass("chanpin");
       Elements elements2 =doc.select("div[id=chanpin_gaikuang]");
       for(Element i:elements1) {
       	Pharmaceuticals pharmaceuticals=new Pharmaceuticals();
       	src=i.select("div[id=chanpin_tupian]").select("a[target=_blank]").first().getElementsByTag("img").attr("src");
       	urlimg=i.select("div[id=chanpin_tupian]").select("a[target=_blank]").first().getElementsByTag("a").attr("href");
       	Element elem_gaikuang=i.getElementById("chanpin_gaikuang");
       	Elements elems_strong=elem_gaikuang.getElementsByTag("strong");
       	alt=elems_strong.get(0).text()+elem_gaikuang.textNodes().get(0);
      		number=elems_strong.get(1).text()+elem_gaikuang.textNodes().get(1);
      		specifications=elems_strong.get(2).text()+elem_gaikuang.textNodes().get(2);
      		enterprises=elems_strong.get(3).text()+elem_gaikuang.textNodes().get(3);
      		business=elems_strong.get(4).text()+elem_gaikuang.getElementsByTag("a").first().text();
      		introduction=elem_gaikuang.getElementById("chanpin_gongneng").text();
      		pharmaceuticals.setAlt(alt);
      		pharmaceuticals.setBusiness(business);
      		pharmaceuticals.setEnterprises(enterprises);
      		pharmaceuticals.setIntroduction(introduction);
      		pharmaceuticals.setNumber(number);
      		pharmaceuticals.setSpecifications(specifications);
      		pharmaceuticals.setSrc(src);
      		pharmaceuticals.setUrlimg(urlimg);
      		Pharmaceuticalslist.add(pharmaceuticals);
       }
       System.out.println(Pharmaceuticalslist);
		return Pharmaceuticalslist;
    	
    }
    @SuppressWarnings("null")
	public static Pharmaceuticals getitemdetail(String urlimg) throws IOException {
    	String url=starturl+urlimg;
    	String[] a = new String[100];
    	Pharmaceuticals pharmaceuticals=new Pharmaceuticals();
    	Document doc = Jsoup.connect(url) .timeout(60000).get();
        doc.html();
        Element total=doc.getElementsByClass("chanpin").first();
        String alt,src,number,specifications,enterprises,business,introduction,urlimg2;
        src=total.getElementById("chanpin_tupian1").getElementsByTag("a").get(0).getElementsByTag("img").attr("src");
        Element table = total.getElementById("chanpin_gaikuang1").getElementsByTag("table").first();
        	for(int i=0;i<table.getElementsByTag("tr").size();i++) {
        		Element tr=table.getElementsByTag("tr").get(i);
        		a[i]=tr.getElementsByTag("td").get(0).text()+":"+tr.getElementsByTag("td").get(1).text();
        	}
        	System.out.println("aaaaaaa");
        	pharmaceuticals.setAlt(a[0]);
        	pharmaceuticals.setNumber(a[2]);
        	pharmaceuticals.setSpecifications(a[3]);
        	pharmaceuticals.setUsemethod(a[4]);
        	pharmaceuticals.setEnterprises(a[5]);
        	pharmaceuticals.setBusiness(a[6]);
        	pharmaceuticals.setComponents(a[7]);
        	pharmaceuticals.setIntroduction(a[8]);
        	pharmaceuticals.setAdvantage(a[9]);
        	pharmaceuticals.setSrc(src);
    	return pharmaceuticals;
    }
 
}