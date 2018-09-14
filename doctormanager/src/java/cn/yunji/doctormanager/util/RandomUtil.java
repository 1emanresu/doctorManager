/**@Title:RandomUtil.java
 * @description：随机验证码工具类
 * @author king_smm
 * @date 2017年7月22日下午2:57:53
 * @copyright(c) 2017 云济健康管理(深圳)有限公司 AllRight Reserved.
 */
package cn.yunji.doctormanager.util;

import java.util.Random;
public class RandomUtil {
    /**
     * @Discription:生成指定长度的验证码
     * @author king
     * @param createRandomVcodeLength
     * @return String
     */
    public static final String createRandomVcodeLength(int length) {
        // 组成验证码的字符
        String[] VCodeArrary={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
               "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
               "A","B","C","D","E","F","G","H","I","J", "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
               };
        String VCode = "";
        Random random = new Random();
        for(int i=0;i<length;i++){
        	VCode += VCodeArrary[random.nextInt(VCodeArrary.length)];
        }
        return VCode;
    }
    
	/**
     * @Discription:随机生成6位数字随机验证码
     * @return String
     * @Author: king
    */
   public static String createRandomVcode(){
     //验证码
   	StringBuilder code = new StringBuilder();
   	Random random = new Random();
   	// 生成6位验证码
   	for (int i = 0; i < 6; i++) {
   	code.append(String.valueOf(random.nextInt(10)));
   	}
	return code.toString();
   }
}

