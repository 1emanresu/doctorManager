package cn.yunji.doctormanager.util;

/**
 * NST评分法
 * 
 * @author yinzx
 *
 */
public class NSTscore {
	// 胎心基线得分
	private int flineScore;
	// 振幅变异得分
	private int fwaveScore;
	// 胎动时FHR上升时间得分
	private int friseScore;
	// 胎动时FHR上升幅度得分
	private int fchangeScore;
	// 胎动次数得分
	private int fmoveScore;
	// 胎心基线
	private int fline;
	// 振幅变异
	private int fwave;
	// 胎动时FHR上升时间
	private int frise;
	// 胎动时FHR上升幅度
	private int fchange;
	// 胎动次数
	private int fmove;
	// Fischer总分
	private int sumScore;

	public int getFlineScore() {
		return flineScore;
	}

	public void setFlineScore(int flineScore) {
		this.flineScore = flineScore;
	}

	public int getFline() {
		return fline;
	}

	public void setFline(int fline) {
		this.fline = fline;
	}

	public int getFwave() {
		return fwave;
	}

	public void setFwave(int fwave) {
		this.fwave = fwave;
	}

	public int getFrise() {
		return frise;
	}

	public void setFrise(int frise) {
		this.frise = frise;
	}

	public int getFchange() {
		return fchange;
	}

	public void setFchange(int fchange) {
		this.fchange = fchange;
	}

	public int getFmove() {
		return fmove;
	}

	public void setFmove(int fmove) {
		this.fmove = fmove;
	}

	public int getFwaveScore() {
		return fwaveScore;
	}

	public void setFwaveScore(int fwaveScore) {
		this.fwaveScore = fwaveScore;
	}

	public int getFriseScore() {
		return friseScore;
	}

	public void setFriseScore(int friseScore) {
		this.friseScore = friseScore;
	}

	public int getFchangeScore() {
		return fchangeScore;
	}

	public void setFchangeScore(int fchangeScore) {
		this.fchangeScore = fchangeScore;
	}

	public int getFmoveScore() {
		return fmoveScore;
	}

	public void setFmoveScore(int fmoveScore) {
		this.fmoveScore = fmoveScore;
	}

	public int getSumScore() {
		return fmoveScore+fchangeScore+friseScore+fwaveScore+flineScore;
	}

	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}

	

}
