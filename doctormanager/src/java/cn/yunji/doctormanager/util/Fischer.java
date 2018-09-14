package cn.yunji.doctormanager.util;
/**
 * 改良后Fischer评分表
 * @author yinzx
 *
 */
public class Fischer {
    //胎心基线得分
	private int flineScore;
	//振幅变异得分
	private int fwaveScore;
	//周期变异得分
	private int fweeklyScore;
	//加速得分
	private int speedUpScore;
	//减速得分
	private int decelerateSorce;
	 //胎心基线
	private int fline;
	//振幅变异
	private int fwave;
	//周期变异
	private int fweekly;
	//加速
	private int speedUp;
	//减速
	private String decelerate;
	//Fischer总分
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
	public String getDecelerate() {
		return decelerate;
	}
	public void setDecelerate(String decelerate) {
		this.decelerate = decelerate;
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
	
	public int getSumScore() {
		return flineScore+fwaveScore+fweeklyScore+speedUpScore+decelerateSorce;
	}
	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}
	
	
}
