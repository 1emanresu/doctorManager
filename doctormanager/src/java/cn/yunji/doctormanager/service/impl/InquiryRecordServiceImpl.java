package cn.yunji.doctormanager.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.yunji.doctormanager.dao.InquiryRecordMapper;
import cn.yunji.doctormanager.entity.InquiryRecord;
import cn.yunji.doctormanager.service.InquiryRecordService;


@Service("inquiryRecord")
public class InquiryRecordServiceImpl implements InquiryRecordService {
	@Resource
	private InquiryRecordMapper inquiryRecordDao;

	@Override
	public List<InquiryRecord> findByDate(InquiryRecord record) {
		return inquiryRecordDao.findByDate(record);
	}

	@Override
	public int insert(InquiryRecord record) {
		return inquiryRecordDao.insert(record);
	}

	@Override
	public List<InquiryRecord> findByDateRange(String mid, Date start, Date end) {
		return inquiryRecordDao.findByDateRange(mid, start, end);
	}
	@Override
	public List<InquiryRecord> findByMid(String mid, String keyword,String sdate,String edate, Integer pageIndex, Integer pageSize) {
		return inquiryRecordDao.findByMid(mid,keyword, sdate, edate,pageIndex,pageSize);
	}

    @Override
    public InquiryRecord findByQid(Integer qid) {
        return inquiryRecordDao.findByQid(qid);
    }

	@Override
	public List<InquiryRecord> selectByMid(String mid) {
		return inquiryRecordDao.selectByMid(mid);
	}

    @Override
    public List<Map<String, Object>> findAllByMid(String mid) {
        // TODO Auto-generated method stub
        return inquiryRecordDao.findAllByMid(mid);
    }


}
