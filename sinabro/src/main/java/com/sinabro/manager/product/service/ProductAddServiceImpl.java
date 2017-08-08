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
			System.out.println(file.getOriginalFilename()+"���� �̸�");
			if(!file.getOriginalFilename().equals("")||!file.getOriginalFilename().equals(null)) {//���ϸ��� �����Ҷ�
				File dir=new File(uploadPath+"/main/"+vo.getProduct_code());
				if(!dir.exists()) {//���� �������� ������ ������
					dir.mkdirs();
				}else {//�����Ѵٸ� �α׸� ������.
					if(i==0) {
						File []files=dir.listFiles();
						for(File f:files) {
							f.delete();
						}
					}
				}
			String orgfilename=file.getOriginalFilename();
			File mainFile=new File(uploadPath+"/main/"+vo.getProduct_code()+"/"+orgfilename);
			
				file.transferTo(mainFile);//���� ����
			str.append("/images/product/main/");
			str.append(vo.getProduct_code());
			str.append("/");
			str.append(orgfilename);//�ҷ��� ��� ����.
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
