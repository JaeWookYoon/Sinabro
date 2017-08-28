package com.sinabro.user.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductVO;
import com.sinabro.user.product.service.ProductListService;
import com.sinabro.util.Paging;


@Controller
public class ProductListController {

   private ProductListService productListService;
   
   public void setProductListService(ProductListService productListService) {
      this.productListService = productListService;
   }

   @RequestMapping(value="productList.do",method=RequestMethod.GET)
   public ModelAndView getProductList(HttpServletRequest request) {
      int pageNum=0;
      ModelAndView model=new ModelAndView();
      Paging page=new Paging();
      List<ProductVO>list=null;
      Map<String,Object>map=new HashMap<String,Object>();
      HttpSession session=request.getSession(false);
      try {
      if(request.getParameter("pageNum")==null||request.getParameter("pageNum").equals(null)) {
         pageNum=1;
      }else {
         pageNum=Integer.valueOf(request.getParameter("pageNum"));
      }
      if(request.getParameter("brand")==null||request.getParameter("brand").equals(null)||request.getParameter("brand")==""||request.getParameter("brand").equals("")) {
         map.put("brand", "ALL");
         session.setAttribute("branda", "ALL");
      }else {
         map.put("brand",  request.getParameter("brand"));
         BrandVO vo=productListService.getBrand(request.getParameter("brand"));
         model.addObject("brand", vo);
         session.setAttribute("branda", request.getParameter("brand"));
      }
      if(request.getParameter("category")==null||request.getParameter("category").equals(null)||request.getParameter("category")==""||request.getParameter("category").equals("")) {
         map.put("category","ALL");
         session.setAttribute("categorya", "ALL");
      }else {
         map.put("category", request.getParameter("category"));
         session.setAttribute("categorya", request.getParameter("category"));
      }
      }catch(Exception e) {
         e.printStackTrace();
      }
      int listCount=productListService.getListCount(map);
      page.setPaging(20,5,listCount,pageNum);//paging처리
      
      int startNum=page.getWriting_Start();
      int endNum=page.getWriting_End();
      map.put("startRow", startNum);map.put("endRow", endNum);
      list=productListService.getProductList(map);
      model.addObject("brandAll", productListService.getBrand());
      for(int i=0;i<list.size();i++) {
         String img=list.get(i).getMainImg().substring(0, list.get(i).getMainImg().length()-1);
         String[]imgs=img.split(";");
         list.get(i).setMainImg(imgs[0]);
         
         
      }
      int startPage=page.getPage_Start();
      int endPage=page.getPage_End();
      if(endPage>=page.getPage_Count()) {
         endPage=page.getPage_Count();
      }
      int pageCount=page.getPage_Count();
      model.addObject("pageCount", pageCount);
      model.addObject("startPage", startPage);
      model.addObject("endPage", endPage);
      model.addObject("startNum", startNum);
      model.addObject("endNum", endNum);
      model.addObject("pageBlock", page.getPageBlock());
      model.addObject("count", page.getCount());
      model.addObject("list", list);
      model.addObject("listCount", list.size());
      model.addObject("pageSize",page.getPageSize());
      model.addObject("pre",page.isPre());
      model.addObject("post",page.isNext());
      model.addObject("tdcount",new Integer(1));
      model.setViewName("product/productList");
      
      return model;
   }
   @RequestMapping(value="/hi.do",method=RequestMethod.GET)
   public ModelAndView getMain(HttpServletRequest request) {
      String pageNum="0";
      if(request.getParameter("pageNum")==null) {
         pageNum="1";
      }else {
         pageNum=request.getParameter("pageNum");
      }
      int currentPage=Integer.valueOf(pageNum);
      ModelAndView model=new ModelAndView();
      Map<String,Object> map=new HashMap<String,Object>();
      List<BrandVO> brand=productListService.getBrand();
      Paging page=new Paging();
      int pageSize=20;
      int pageBlock=5;
      map.put("brand", "ALL"); map.put("category", "ALL");
      int listcount=productListService.getListCount(map);
      page.setPaging(pageSize, pageBlock, listcount, currentPage);
      int startRow=page.getWriting_Start();int endRow=page.getWriting_End();
      map.put("startRow",startRow); map.put("endRow", endRow);
      List<ProductVO> productList=productListService.getProductList(map);
      
      for(int i=0;i<productList.size();i++) {
         String [] img=productList.get(i).getMainImg().substring(0, productList.get(i).getMainImg().length()-1).split(";");
         productList.get(i).setMainImg(img[0]);
      }
      int endPage=page.getPage_End();
      int pageCount=page.getPage_Count();
      if(endPage>=pageCount) {
         endPage=pageCount;
      }
      model.addObject("list",productList);
      model.addObject("pre",page.isPre());
      model.addObject("post", page.isNext());
      model.addObject("pageBlock", pageBlock);
      model.addObject("startPage", page.getPage_Start());
      model.addObject("endPage", endPage);
      model.addObject("brand", brand);
      model.setViewName("member/mainContent");
      
      
      return model;
   }
   @RequestMapping(value="productContent.do",method=RequestMethod.GET)
      public ModelAndView getProductContent(@RequestParam("product_code")String code) {
         ModelAndView model=new ModelAndView();
         ProductVO vo=productListService.getProductContent(code);
         String mainImg=vo.getMainImg().substring(0, vo.getMainImg().length()-1);
         
         String sizea=vo.getSizea().substring(0,vo.getSizea().length()-1);
         String quantitya=vo.getQuantity().substring(0,vo.getQuantity().length()-1);
         String[]img=mainImg.split(";");
         String[]size=sizea.split(";");
         String[]quantity=quantitya.split(";");
         BrandVO bvo=productListService.getBrand(vo.getBrand());
         for(int i=0;i<quantity.length;i++) {
        	 if(Integer.valueOf(quantity[i])==0) {
        		 quantity[i]="품절";
        	 }
         }
         String price=String.valueOf(vo.getPrice());
         String price1=price.substring(0, price.length()-3);
         String price2=price.substring(price.length()-3, price.length());
         StringBuilder str=new StringBuilder();
         str.append(price1);
         str.append(",");
         str.append(price2);
         String price3=str.toString();
         model.addObject("brand", bvo);
         model.addObject("vo",vo);
         model.addObject("price", price3);
         model.addObject("milage", Integer.valueOf(price));
         model.addObject("listCount", size.length);
         model.addObject("img", img);model.addObject("size", size);model.addObject("quantity", quantity);
         model.setViewName("product/productContent");
            return model;
      }
      
      
      
      
      
      
}