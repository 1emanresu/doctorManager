package cn.yunji.doctormanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yunji.doctormanager.dao.AntenatalcaretimeMapper;
import cn.yunji.doctormanager.entity.Antenatalcaretime;
import cn.yunji.doctormanager.service.AntenatalcaretimeService;

@Service("antenatalcaretimeService")
public class AntenatalcaretimeServiceImpl implements AntenatalcaretimeService{
	@Resource
	private AntenatalcaretimeMapper antenatalcaretimedao;

	@Override
	public List<Antenatalcaretime> queryAntenatalcaretime(String mid) {
		return antenatalcaretimedao.queryAntenatalcaretime(mid);
	}

	@Override
	public Antenatalcaretime findfirstExtendCheckprojectId(String date, String mid) {
		// TODO Auto-generated method stub
		return antenatalcaretimedao.findfirstExtendCheckprojectId(date, mid);
	}

	@Override
	public Antenatalcaretime findsecondExtendCheckprojectId(String date, String mid) {
		// TODO Auto-generated method stub
		return antenatalcaretimedao.findsecondExtendCheckprojectId(date, mid);
	}

	@Override
	public Antenatalcaretime findthirdExtendCheckprojectId(String date, String mid) {
		// TODO Auto-generated method stub
		return antenatalcaretimedao.findthirdExtendCheckprojectId(date, mid);
	}

	@Override
	public Antenatalcaretime findfourthExtendCheckprojectId(String date, String mid) {
		// TODO Auto-generated method stub
		return antenatalcaretimedao.findfourthExtendCheckprojectId(date, mid);
	}

	@Override
	public Antenatalcaretime findfifthExtendCheckprojectId(String date, String mid) {
		// TODO Auto-generated method stub
		return antenatalcaretimedao.findfifthExtendCheckprojectId(date, mid);
	}

	@Override
	public Antenatalcaretime findsixthExtendCheckprojectId(String date, String mid) {
		// TODO Auto-generated method stub
		return antenatalcaretimedao.findsixthExtendCheckprojectId(date, mid);
	}

	@Override
	public Antenatalcaretime findsevenExtendCheckprojectId(String date, String mid) {
		// TODO Auto-generated method stub
		return antenatalcaretimedao.findsevenExtendCheckprojectId(date, mid);
	}
}
