package cn.yunji.doctormanager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yunji.doctormanager.entity.MyCollection;
import cn.yunji.doctormanager.service.MyCollectionService;
import cn.yunji.doctormanager.util.JsonResult;

/**
 * 我的收藏
 * @author zhangqt
 * @CreateDate 2017年12月11日 下午3:49:08
 */
@RequestMapping("/myCollection")
@Controller
public class MyCollectionController {
	@Resource
	private MyCollectionService myCollectionService;
	/**
	 * 添加收藏
	 * @param myCollection
	 * @return int
	 * @author zhangqt
	 * @createDate 2017年12月11日 下午3:51:11
	 */
	@RequestMapping("/insert.do")
	@ResponseBody
	public int insert(MyCollection myCollection) {
		return myCollectionService.insert(myCollection);
	}
	/** 
	 * 以孕妇id查询收藏的视频
	 * @param mid
	 * @return
	 * @author zhangqt
	 * @createDate 2017年12月11日 下午5:11:09
	 */
	@RequestMapping("/queryByMid.do")
	@ResponseBody
	public JsonResult queryByMid(String mid){
		return new JsonResult(myCollectionService.queryByMid(mid));
	}
	
	/** 
	 * 以主键删除收藏
	 * @param mid
	 * @return
	 * @author zhangqt
	 * @createDate 2017年12月11日 下午5:11:09
	 */
	@RequestMapping("/deleteByCid.do")
	@ResponseBody
	public int deleteByCid(Integer cid){
		return myCollectionService.deleteByCid(cid);
	}
	
}
