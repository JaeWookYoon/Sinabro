package com.sinabro.user.payment.service;

import org.springframework.transaction.annotation.Transactional;

import com.sinabro.model.PaymentVO;
import com.sinabro.user.payment.dao.PaymentOrderDAO;
import com.sinabro.util.MakeCode;

public class PaymentOrderServiceImpl implements PaymentOrderService {

	private PaymentOrderDAO paymentOrderDAO;
	
	public void setPaymentOrderDAO(PaymentOrderDAO paymentOrderDAO) {
		this.paymentOrderDAO = paymentOrderDAO;
	}
	@Transactional
	@Override
	public int orderExec(PaymentVO payment) {
		int reducemilage=0;
		int reduce=0;int insert=0;int mileage=0;int delete=0;
		
		if(!payment.getProduct_codea().isEmpty()) {//�� �� �ֹ��� ���
			
			for(int z=0;z<payment.getProduct_codea().size();z+=1) {
				PaymentVO vo=new PaymentVO();
				System.out.println(payment.getProduct_codea().get(z)+"�ڵ�");
				vo.setId(payment.getId());
				vo.setProduct_code(payment.getProduct_codea().get(z));//�迭�� �� ���� ����//������
				vo.setPrice(payment.getPricea().get(z));//������
				vo.setOrder_code(payment.getOrder_code());//�ֹ��ڵ� ����
				vo.setStatus("�ֹ��Ϸ�");
				vo.setAddress(payment.getAddress());
				vo.setOrder_message(payment.getOrder_message());
				vo.setSizea(payment.getSizeaa().get(z));//������
				vo.setMilage(payment.getMilagea().get(z));//������
				vo.setNameone(payment.getNameone());
				vo.setTotal(payment.getTotal());
				int UserMilage=paymentOrderDAO.getUserMilage(vo.getId());
				if(UserMilage>=payment.getUsemilage()) {
					vo.setUsemilage(payment.getUsemilage()/payment.getProduct_codea().size());
					vo.setPrice(vo.getPrice()-vo.getUsemilage());
					reducemilage=paymentOrderDAO.reduceMilage(vo.getId(), vo.getUsemilage());
					System.out.println("reduceMilage:"+reducemilage);
				}else {
					return -1;
				}
				System.out.println(vo.getProduct_code()+"���� �ڵ�");
				String sizeList=paymentOrderDAO.getSize(vo.getProduct_code());//i��° ��ǰ ������ �޾ƿ���
				String quanList=paymentOrderDAO.getQuan(vo.getProduct_code());//i��° ��ǰ ���� �޾ƿ���
				String []sizes=sizeList.substring(0, sizeList.length()-1).split(";");
				String []quans=quanList.substring(0, quanList.length()-1).split(";");
				StringBuilder str=new StringBuilder();
				for(int j=0;j<sizes.length;j++) {
					if(sizes[j].equals(vo.getSizea())) {//i��° ��ǰ�� ������ �� ���� ��û ������� ������ ��
						int quan=Integer.valueOf(quans[j])-1;
						quans[j]=String.valueOf(quan);//����� ã�� ���� ���ҽ�Ű��
					}//end of if
					str.append(quans[j]);
					str.append(";");//quan�� �ٽ� ����
				}//end of j
				reduce=paymentOrderDAO.reduceQuantity(vo.getProduct_code(), str.toString());//���� ����
				System.out.println("reduce:"+reduce);
				
				insert=paymentOrderDAO.insertPayment(vo);//�Ǹ���� ���
				System.out.println("insert:"+insert);
				
			mileage=paymentOrderDAO.updateMilage(vo.getId(), vo.getMilage());
			System.out.println("updateMilage:"+mileage);//���ϸ��� �߰�
			delete=paymentOrderDAO.deleteCart(vo.getId(), vo.getProduct_code());
			System.out.println("deleteCart:"+delete);//īƮ ����
			
			}//end of i
			
		}else {
			String sizeList=paymentOrderDAO.getSize(payment.getProduct_code());
			String quanList=paymentOrderDAO.getQuan(payment.getProduct_code());
			String[]sizes=sizeList.substring(0, sizeList.length()-1).split(";");
			String[]quans=quanList.substring(0, quanList.length()-1).split(";");
			StringBuilder str=new StringBuilder();
			for(int i=0;i<sizes.length;i++) {
				if(sizes[i].equals(payment.getSizea())){
					int qq=Integer.valueOf(quans[i])-1;
					quans[i]=String.valueOf(qq);
				}
				str.append(quans[i]);
				str.append(";");
			}//end of i
			reduce=paymentOrderDAO.reduceQuantity(payment.getProduct_code(), str.toString());
			System.out.println("reduce:"+reduce);
			insert=paymentOrderDAO.insertPayment(payment);
			System.out.println("insert:"+insert);
			mileage=paymentOrderDAO.updateMilage(payment.getId(), payment.getMilage());
			System.out.println("updateMilage:"+mileage);//���ϸ��� �߰�
			delete=paymentOrderDAO.deleteCart(payment.getId(), payment.getProduct_code());
			System.out.println("deleteCart:"+delete);//īƮ ����
		}//end of else
		int result=reduce+insert+mileage+delete+reducemilage;
		return result;
	}

}
