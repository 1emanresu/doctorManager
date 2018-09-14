package cn.yunji.doctormanager.controller;

import java.io.File;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;
/*
 * 此类用作转码，解决手机录音电脑浏览器不能用的问题
 * author:zhangqt
 * */
public class WavToMp3 {
	public static void toWav(String path,String fileName){
		File source = new File(path+fileName);
		File target = new File(path+"w"+fileName);
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("pcm_s16le");
		audio.setBitRate(new Integer(8000));//设置比特率
		audio.setChannels(new Integer(1));
		audio.setSamplingRate(new Integer(11025));//设置节录率
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("wav");
		attrs.setAudioAttributes(audio);
		Encoder encoder = new Encoder();
		
		
		try {
			encoder.encode(source, target, attrs);
		} catch (Exception e) {
		}
		source.delete();
	}

}