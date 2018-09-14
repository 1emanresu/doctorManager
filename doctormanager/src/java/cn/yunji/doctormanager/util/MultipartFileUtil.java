package cn.yunji.doctormanager.util;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import cn.yunji.doctormanager.controller.exception.ServiceException;

/**
 * multipartfile工具类
 * @author oumh
 * @CreateDate 2018年1月17日 下午3:46:57
 */
public class MultipartFileUtil {

	/** 
	 * 将multipartfile转存至本地
	 * @param uploadFile
	 * @param path
	 * @return
	 * @author oumh
	 * @createDate 2018年1月17日 下午3:47:13
	 */
	public static String multipartFileTransferToLocal(MultipartFile uploadFile, String path) {
		String destfileName = null;
		if(uploadFile==null)
			throw new ServiceException("需要选择上传文件");
		if(uploadFile.isEmpty())
			throw new ServiceException("上传文件不能为空");
		if(uploadFile != null){
			// 构建文件上传路径
			File uploadDir = new File(path);
			//创建目录
			if(!uploadDir.exists()){
				uploadDir.mkdirs();
			}

			//构建新的文件名(相同目录下不允许出现重复的名字)
			String srcFileName=
					uploadFile.getOriginalFilename();
			destfileName=
					UUID.randomUUID().toString()+"."
							+FilenameUtils.getExtension(srcFileName);//构建随机
			//创建空文件
			File dest = new File(uploadDir,destfileName);
			try {
				uploadFile.transferTo(dest);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServiceException("文件上传失败！");
			}
		}
		return destfileName;
	}

}
