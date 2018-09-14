package cn.yunji.doctormanager.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import Decoder.BASE64Decoder;
import cn.yunji.doctormanager.util.BaiduSpeech;
import cn.yunji.doctormanager.util.SimpleResult;

/*
 * 上传wav音频与图像上传的控制器
 * author:zhangqt
 * */
@Controller
public class AudioController {
	private List<String> list = new ArrayList<String>();

	@SuppressWarnings("resource")
	@ResponseBody
	@RequestMapping(value = "/audupload.do", produces = { "application/text;charset=UTF-8" })
	public String LogoUpload(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("/");
		String imgpath = "audio/chat/";
		File dir = new File(path + imgpath);
//		System.out.println(path + imgpath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String uuid = UUID.randomUUID().toString().replace("-", "");
		file.transferTo(new File(path + imgpath + uuid + ".wav"));
		//BaiduSpeech.getToken();
		WavToMp3.toWav(path + imgpath, uuid + ".wav");
		return  uuid + ".wav";
	} 
	/**
	 * @author wangzw
	 * @param request
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
    @RequestMapping(value = "/auUploads.do", produces = { "application/text;charset=UTF-8" })
    public String auUploads(HttpServletRequest request,String  file) throws Exception {
	    File f = new File(file);   
        String path = request.getSession().getServletContext().getRealPath("/");
        String imgpath = "audio/chat/w/";
        File dir = new File(path + imgpath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        FileInputStream fis = new FileInputStream(f);
        //如果下面的语句使用BufferedOutputStream来修饰则带来更好的性能现。
        FileOutputStream fos = new FileOutputStream(dir + f.getName());  
        int length = 0;
        byte[] b = new byte[1024];
        while((length = fis.read(b)) != -1)
        {
            fos.write(b, 0, length);
        }
        fos.close();
        fis.close();
        return "ok";
    } 
	
	public String picId() {
		UUID uuid = UUID.randomUUID();
		String suuid = uuid.toString();
		suuid = suuid.replace("-", "");
		return suuid;
	}

	@SuppressWarnings("resource")
	@ResponseBody
	@RequestMapping("/PicUpload.do")
	public Object pictureUpload(String imgdata, HttpServletRequest request) {
//			System.out.println(imgdata);
		BASE64Decoder decoder = new BASE64Decoder();
		FileOutputStream outputstream;
		try {
			String basepath = request.getServletContext().getRealPath("/");
			File folder = new File(basepath + "img/chat/");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			String filename = basepath + "img/chat/" + picId() + ".jpg";
//			System.out.println(filename);
			File imgfile = new File(filename);
			outputstream = new FileOutputStream(imgfile);
			byte[] result = decoder.decodeBuffer(imgdata.split(",")[1]);
			for (int i = 0; i < result.length; i++) {
				if (result[i] < 0) {
					result[i] += 256;
				}
			}
			outputstream.write(result);
			String name = filename.substring(filename.lastIndexOf('/') + 1);
			list.add(name);
			outputstream.flush();
			outputstream.close();

			return new SimpleResult(true, filename);
		} catch (IOException e) {
			e.printStackTrace();
			return new SimpleResult(false, "上传文件失败");
		}
	}

	@ResponseBody
	@RequestMapping("/getImg.do")
	public List<String> imgList(HttpServletRequest request) {
//		System.out.println("/getImg.do");

		return list;
	}

}
