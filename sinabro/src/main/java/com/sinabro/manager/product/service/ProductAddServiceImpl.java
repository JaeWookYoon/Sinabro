package com.sinabro.manager.product.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sinabro.manager.product.dao.ProductAddDAO;
import com.sinabro.model.ProductVO;

public class ProductAddServiceImpl implements ProductAddService{

	private ProductAddDAO productDao;
	
	
	public void setProductDao(ProductAddDAO productDao) {
		this.productDao = productDao;
	}

	
	
	
	@Override
	public int addProduct(ProductVO vo, String uploadPath) {
		int result=0;
		List<MultipartFile> imgFile=vo.getImgFile();
		try {
			StringBuilder str=new StringBuilder();
		for(int i=0;i<imgFile.size();i++) {
			MultipartFile file=imgFile.get(i);
			if(!file.getOriginalFilename().equals("")||!file.getOriginalFilename().equals(null)) {//파일명이 존재할때
				File dir=new File(uploadPath+"/main/"+vo.getProduct_code());
				if(!dir.exists()) {//폴더 존재하지 않으면 만들자
					dir.mkdirs();
				}else {//존재한다면 싸그리 없애자.
					if(i==0) {
						File[]files=dir.listFiles();
						for(File f:files) {
							f.delete();
						}//싹다 지워버린다.
					}//파일 목록 읽어오기 전에
				}
			String orgfilename=file.getOriginalFilename();
			File mainFile=new File(uploadPath+"/main/"+vo.getProduct_code()+"/"+orgfilename);
			
				file.transferTo(mainFile);//파일 전송
			str.append("/images/product/main/");
			str.append(vo.getProduct_code());
			str.append("/");
			str.append(orgfilename);//불러올 경로 지정.
			//setting
			vo.setMainImg(str.toString());
			str.delete(0, str.length());
			vo.setSizea(vo.getSizeaa().get(i));//사이즈 지정
			vo.setQuantity(vo.getQuantitya().get(i));//수량 지정
			result=productDao.addProduct(vo);
			}//파일명이 존재할때
		}//end for
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}




	@Override
	public boolean checkBrand(String brand) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
		if(productDao.checkBrand(brand)==0){//브랜드가 없으면 트루
			result=true;
		}else {
			
			result=false;
		}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}




	@Override
	public int newProductCode(String product_code) {
		
		return productDao.newProductCode(product_code);
	}




	@Override
	public int insertBrand(String brand) {
		// TODO Auto-generated method stub
		return productDao.insertBrand(brand);
	}
	
	

}
