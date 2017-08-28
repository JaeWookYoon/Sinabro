package com.sinabro.user.usedboard.service;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.sinabro.model.UsedBoardVO;
import com.sinabro.user.usedboard.dao.UsedBoardDao;

public class UsedUpdateArticleServiceImpl implements UsedUpdateArticleService {

	private UsedBoardDao usedBoardDao;

	public void setUsedBoardDao(UsedBoardDao usedBoardDao) {
		this.usedBoardDao = usedBoardDao;
	}

	@Override
	public UsedBoardVO getArticle(Integer num) {
		return this.usedBoardDao.getArticle(num);
	}

	

	@Override
	public void updateArticle(UsedBoardVO usedBoardVo, String uploadPath) {
		
		List<MultipartFile> imgFile = usedBoardVo.getImgFile();

		Calendar cal = Calendar.getInstance();
		// File.separator : ���丮 ������(\\)

		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		// ��¥, ex) \\2017\\03\\01
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));


		try {
			UUID uuid = UUID.randomUUID();
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < imgFile.size(); i++) {
				MultipartFile file = imgFile.get(i);
				System.out.println(file.getOriginalFilename() + "���� �̸�");
				if (!file.getOriginalFilename().equals("") || !file.getOriginalFilename().equals(null)) {// ���ϸ��� �����Ҷ�
					File dir = new File(uploadPath + datePath);
					if (!dir.exists()) {// ������ ���ٸ� �����.
						dir.mkdirs();
					}
					// uuid ����(Universal Unique IDentifier, ���� ���� �ĺ���)

					String orgfilename = file.getOriginalFilename();
					File mainFile = new File(uploadPath + datePath + "/" + orgfilename + "_" + uuid.toString());
					file.transferTo(mainFile);// ���� ����
					str.append("/images/used/");

					str.append(datePath + "/" + orgfilename + "_" + uuid.toString());// �ҷ��� ��� ����
					str.append(";");
					usedBoardVo.setMainimg(str.toString());
					System.out.println(usedBoardVo.getMainimg());
					System.out.println(uploadPath);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.usedBoardDao.updateArticle(usedBoardVo);
	}
}
