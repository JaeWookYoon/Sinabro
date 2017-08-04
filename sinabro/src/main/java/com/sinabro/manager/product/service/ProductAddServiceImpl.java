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
			if(!file.getOriginalFilename().equals("")||!file.getOriginalFilename().equals(null)) {//���ϸ��� �����Ҷ�
				File dir=new File(uploadPath+"/main/"+vo.getProduct_code());
				if(!dir.exists()) {//���� �������� ������ ������
					dir.mkdirs();
				}else {//�����Ѵٸ� �α׸� ������.
					if(i==0) {
						File[]files=dir.listFiles();
						for(File f:files) {
							f.delete();
						}//�ϴ� ����������.
					}//���� ��� �о���� ����
				}
			String orgfilename=file.getOriginalFilename();
			File mainFile=new File(uploadPath+"/main/"+vo.getProduct_code()+"/"+orgfilename);
			
				file.transferTo(mainFile);//���� ����
			str.append("/images/product/main/");
			str.append(vo.getProduct_code());
			str.append("/");
			str.append(orgfilename);//�ҷ��� ��� ����.
			//setting
			vo.setMainImg(str.toString());
			str.delete(0, str.length());
			vo.setSizea(vo.getSizeaa().get(i));//������ ����
			vo.setQuantity(vo.getQuantitya().get(i));//���� ����
			result=productDao.addProduct(vo);
			}//���ϸ��� �����Ҷ�
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
		if(productDao.checkBrand(brand)==0){//�귣�尡 ������ Ʈ��
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
