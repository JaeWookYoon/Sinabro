package com.sinabro.manager.product.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sinabro.manager.product.dao.ManagerProductDAO;
import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductVO;

public class ManagerProductServiceImpl implements ManagerProductService {

	private ManagerProductDAO managerProductDAO;
	
	
	
	public void setManagerProductDAO(ManagerProductDAO managerProductDAO) {
		this.managerProductDAO = managerProductDAO;
	}

	@Override
	public List<ProductVO> getProductList(Object param) {
		Map<String, Object> map = (Map<String, Object>) param;

		if (map.get("brand").equals("ALL") && map.get("category").equals("ALL")) {

			return managerProductDAO.getProductList(map);
		}
		if (!map.get("brand").equals("ALL") && map.get("category").equals("ALL")) {//brand
			return managerProductDAO.getProductListB(param);
		}
		if (map.get("brand").equals("ALL") && !map.get("category").equals("ALL")) {//category
			return managerProductDAO.getProductListC(param);
		}

		else {
			return managerProductDAO.getProductListA(param);//both
		}
	}

	@Override
	public int getListCount(Object obj) {
		Map<String,Object> map=(Map)obj;
		if(map.get("brand").equals("ALL")&&map.get("category").equals("ALL")) {
					
					return managerProductDAO.getListCount();
				}if(!map.get("brand").equals("ALL")&&map.get("category").equals("ALL")) {
					return managerProductDAO.getListCountBrand(obj);
				}if(map.get("brand").equals("ALL")&&!map.get("category").equals("ALL")) {
					return managerProductDAO.getListCountCategory(obj);
				}
				
				else {
					return managerProductDAO.getListCountBoth(obj);
				}
					
				
	}

	@Override
	public List<BrandVO> getBrand() {
		// TODO Auto-generated method stub
		return managerProductDAO.getBrand();
	}

	@Override
	public BrandVO getBrand(String brand) {
		// TODO Auto-generated method stub
		return managerProductDAO.getBrand(brand);
	}

	@Override
	public ProductVO getProductContent(String product_code) {
		// TODO Auto-generated method stub
		return managerProductDAO.getProductContent(product_code);
	}

	@Override
	public int updateProduct(ProductVO vo,String uploadPath) {
		
		int result=0;
		List<MultipartFile> imgFile=vo.getImgFile();
		try {
			StringBuilder str=new StringBuilder();
		for(int i=0;i<imgFile.size();i++) {
			MultipartFile file=imgFile.get(i);
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
			File mainFile=new File(uploadPath+"/main/"+vo.getProduct_code()+"/"+orgfilename);
			
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
			quan.append(vo.getQuantitya().get(i));
			quan.append(";");
			vo.setSizea(size.toString());
			vo.setQuantity(quan.toString());
		}
		result=managerProductDAO.updateProduct(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
			

		
		return result;
		
		
	}

	@Override
	public int deleteProduct(String product_code) {
		// TODO Auto-generated method stub
		return managerProductDAO.deleteProduct(product_code);
	}

}
