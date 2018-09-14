package cn.yunji.doctormanager.util;

/**
 * 胎监 Krebs评分法
 * @author yinzx
 *
 */
public class Krebs {

	// 胎心基线得分
	private int flineScore;
	// 振幅变异得分
	private int fwaveScore;
	// 周期变异得分
	private int fweeklyScore;
	// 加速得分
	private int speedUpScore;
	// 减速得分
	private int decelerateSorce;
	// 胎动次数得分
	private int fmoveScore;
	// 胎心基线
	private int fline;
	// 振幅变异
	private int fwave;
	// 周期变异
	private int fweekly;
	// 加速
	private int speedUp;
	// 减速
	private int decelerate;
	// 胎动次数得分
	private int fmove;
	// Krebs总分
	private int sumScore;
	public int getFlineScore() {
		return flineScore;
	}
	public void setFlineScore(int flineScore) {
		this.flineScore = flineScore;
	}
	public int getFwaveScore() {
		return fwaveScore;
	}
	public void setFwaveScore(int fwaveScore) {
		this.fwaveScore = fwaveScore;
	}
	public int getFweeklyScore() {
		return fweeklyScore;
	}
	public void setFweeklyScore(int fweeklyScore) {
		this.fweeklyScore = fweeklyScore;
	}
	public int getSpeedUpScore() {
		return speedUpScore;
	}
	public void setSpeedUpScore(int speedUpScore) {
		this.speedUpScore = speedUpScore;
	}
	public int getDecelerateSorce() {
		return decelerateSorce;
	}
	public void setDecelerateSorce(int decelerateSorce) {
		this.decelerateSorce = decelerateSorce;
	}
	public int getFmoveScore() {
		return fmoveScore;
	}
	public void setFmoveScore(int fmoveScore) {
		this.fmoveScore = fmoveScore;
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
	public int getFweekly() {
		return fweekly;
	}
	public void setFweekly(int fweekly) {
		this.fweekly = fweekly;
	}
	public int getSpeedUp() {
		return speedUp;
	}
	public void setSpeedUp(int speedUp) {
		this.speedUp = speedUp;
	}
	public int getDecelerate() {
		return decelerate;
	}
	public void setDecelerate(int decelerate) {
		this.decelerate = decelerate;
	}
	public int getFmove() {
		return fmove;
	}
	public void setFmove(int fmove) {
		this.fmove = fmove;
	}
	public int getSumScore() {
		return flineScore+fwaveScore+fweeklyScore+speedUpScore+decelerateSorce+fmoveScore;
	}
	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}
	

}
