package com.sinabro.manager.product.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sinabro.manager.product.dao.ProductAddDAO;
import com.sinabro.model.BrandVO;
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
			MultipartFile file=imgFile.get(i);//임시였다면
			System.out.println(file.getOriginalFilename()+"파일 이름");
			if(!file.getOriginalFilename().equals("")||!file.getOriginalFilename().equals(null)) {//파일명이 존재할때
				File dir=new File(uploadPath+"/main/"+vo.getProduct_code());
				if(!dir.exists()) {//폴더 존재하지 않으면 만들자
					dir.mkdirs();
				}else {//존재한다면 싸그리 없애자.
					if(i==0) {
						File []files=dir.listFiles();
						for(File f:files) {
							f.delete();
						}
					}
				}
			String orgfilename=file.getOriginalFilename();
			File mainFile=new File(uploadPath+"/main/"+vo.getProduct_code()+"/"+orgfilename);//진짜 파일
			
				file.transferTo(mainFile);//파일 전송
			str.append("/images/product/main/");
			str.append(vo.getProduct_code());
			str.append("/");
			str.append(orgfilename);//불러올 경로 지정.
			str.append(";");
			//setting
			vo.setMainImg(str.toString());
			System.out.println(vo.getMainImg());
			}
		}//end for
		StringBuilder size=new StringBuilder();
		StringBuilder quan=new StringBuilder();
		for(int i=0;i<vo.getSizeaa().size();i++) {
			size.append(vo.getSizeaa().get(i));
			size.append(";");
			vo.setSizea(size.toString());
			quan.append(vo.getQuantitya().get(i));
			quan.append(";");
			vo.setQuantity(quan.toString());
		}
		result=productDao.addProduct(vo);
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
		if(productDao.checkBrand(brand)!=0){//브랜드가 있으면 트루
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
	public List<BrandVO> getBrand() {
		// TODO Auto-generated method stub
		return productDao.getBrand();
	}




	@Override
	public int updateBrand(BrandVO vo,String uploadPath) {
		StringBuilder sb=new StringBuilder();
		MultipartFile imgFile=vo.getImg();
		int result=0;
		try {
			File dir=new File(uploadPath+"/"+vo.getBrand());
			if(!dir.exists()) {
				dir.mkdirs();
			}else {
				File[]f=dir.listFiles();
				for(File file:f) {
					file.delete();
				}
			}
			String orgname=imgFile.getOriginalFilename();
			File main=new File(uploadPath+"/"+vo.getBrand()+"/"+orgname);
			imgFile.transferTo(main);
			sb.append("/images/product");
			sb.append("/");
			sb.append(vo.getBrand());
			sb.append("/");
			sb.append(orgname);
			vo.setMainimage(sb.toString());
			result=productDao.updateBrand(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}




	@Override
	public int deleteBrand(String brand) {
		// TODO Auto-generated method stub
		return productDao.deleteBrand(brand);
	}




	@Override
	public int insertBrand(BrandVO vo,String uploadPath) {
		StringBuilder sb=new StringBuilder();
		MultipartFile imgFile=vo.getImg();
		int result=0;
		try {
			File dir=new File(uploadPath+"/"+vo.getBrand());
			if(!dir.exists()) {
				dir.mkdirs();
			}else {
				File[]f=dir.listFiles();
				for(File file:f) {
					file.delete();
				}
			}
			String orgname=imgFile.getOriginalFilename();
			File main=new File(uploadPath+"/"+vo.getBrand()+"/"+orgname);
			imgFile.transferTo(main);
			sb.append("/images/product");
			sb.append("/");
			sb.append(vo.getBrand());
			sb.append("/");
			sb.append(orgname);
			vo.setMainimage(sb.toString());
			result=productDao.insertBrand(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	

}
