package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Pregnancy {
    private Integer pcid;
    
    private String mid;

	private String mname;

	private Integer mage;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date pcdate;

	private String location;

	private Integer sibship;

	private Integer menstrualcycle;

	private Integer oneage;

	private Integer quantity;

	private Integer dysmenorrhea;

	private Integer holdtime;

	private String lifestyle;

	private String favorsport;

	private Integer dosport;

	private String sporttime;

	private Integer sportpower;

	private Integer familyrelation;

	private Integer workship;

	private Integer friendship;

	private Integer ready;

	private Integer pressure;

	private Integer folicacid;

	private Integer medicine;

	private Integer meet;

	private Integer fruits;

	private Integer vegetables;

	private Integer pickyeater;

	private Integer hostileeenvironment;

	private String vaccinate;

	private Integer familyhistory;

	private Integer recentmarriage;

	private Integer mentalstate;
	//yinzx 添加备孕体检信息
	private PregnancyCheck pregnancyCheck;

	public Integer getPcid() {
		return pcid;
	}

	public void setPcid(Integer pcid) {
		this.pcid = pcid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname == null ? null : mname.trim();
	}

	public Integer getMage() {
		return mage;
	}

	public void setMage(Integer mage) {
		this.mage = mage;
	}

	public Date getPcdate() {
		return pcdate;
	}

	public void setPcdate(Date pcdate) {
		this.pcdate = pcdate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location == null ? null : location.trim();
	}

	public Integer getSibship() {
		return sibship;
	}

	public void setSibship(Integer sibship) {
		this.sibship = sibship;
	}

	public Integer getMenstrualcycle() {
		return menstrualcycle;
	}

	public void setMenstrualcycle(Integer menstrualcycle) {
		this.menstrualcycle = menstrualcycle;
	}

	public Integer getOneage() {
		return oneage;
	}

	public void setOneage(Integer oneage) {
		this.oneage = oneage;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getDysmenorrhea() {
		return dysmenorrhea;
	}

	public void setDysmenorrhea(Integer dysmenorrhea) {
		this.dysmenorrhea = dysmenorrhea;
	}

	public Integer getHoldtime() {
		return holdtime;
	}

	public void setHoldtime(Integer holdtime) {
		this.holdtime = holdtime;
	}

	public String getLifestyle() {
		return lifestyle;
	}

	public void setLifestyle(String lifestyle) {
		this.lifestyle = lifestyle == null ? null : lifestyle.trim();
	}

	public String getFavorsport() {
		return favorsport;
	}

	public void setFavorsport(String favorsport) {
		this.favorsport = favorsport == null ? null : favorsport.trim();
	}

	public Integer getDosport() {
		return dosport;
	}

	public void setDosport(Integer dosport) {
		this.dosport = dosport;
	}

	public String getSporttime() {
		return sporttime;
	}

	public void setSporttime(String sporttime) {
		this.sporttime = sporttime == null ? null : sporttime.trim();
	}

	public Integer getSportpower() {
		return sportpower;
	}

	public void setSportpower(Integer sportpower) {
		this.sportpower = sportpower;
	}

	public Integer getFamilyrelation() {
		return familyrelation;
	}

	public void setFamilyrelation(Integer familyrelation) {
		this.familyrelation = familyrelation;
	}

	public Integer getWorkship() {
		return workship;
	}

	public void setWorkship(Integer workship) {
		this.workship = workship;
	}

	public Integer getFriendship() {
		return friendship;
	}

	public void setFriendship(Integer friendship) {
		this.friendship = friendship;
	}

	public Integer getReady() {
		return ready;
	}

	public void setReady(Integer ready) {
		this.ready = ready;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getFolicacid() {
		return folicacid;
	}

	public void setFolicacid(Integer folicacid) {
		this.folicacid = folicacid;
	}

	public Integer getMedicine() {
		return medicine;
	}

	public void setMedicine(Integer medicine) {
		this.medicine = medicine;
	}

	public Integer getMeet() {
		return meet;
	}

	public void setMeet(Integer meet) {
		this.meet = meet;
	}

	public Integer getFruits() {
		return fruits;
	}

	public void setFruits(Integer fruits) {
		this.fruits = fruits;
	}

	public Integer getVegetables() {
		return vegetables;
	}

	public void setVegetables(Integer vegetables) {
		this.vegetables = vegetables;
	}

	public Integer getPickyeater() {
		return pickyeater;
	}

	public void setPickyeater(Integer pickyeater) {
		this.pickyeater = pickyeater;
	}

	public Integer getHostileeenvironment() {
		return hostileeenvironment;
	}

	public void setHostileeenvironment(Integer hostileeenvironment) {
		this.hostileeenvironment = hostileeenvironment;
	}

	public String getVaccinate() {
		return vaccinate;
	}

	public void setVaccinate(String vaccinate) {
		this.vaccinate = vaccinate == null ? null : vaccinate.trim();
	}

	public Integer getFamilyhistory() {
		return familyhistory;
	}

	public void setFamilyhistory(Integer familyhistory) {
		this.familyhistory = familyhistory;
	}

	public Integer getRecentmarriage() {
		return recentmarriage;
	}

	public void setRecentmarriage(Integer recentmarriage) {
		this.recentmarriage = recentmarriage;
	}

	public Integer getMentalstate() {
		return mentalstate;
	}

	public void setMentalstate(Integer mentalstate) {
		this.mentalstate = mentalstate;
	}

	public PregnancyCheck getPregnancyCheck() {
        return pregnancyCheck;
    }

    public void setPregnancyCheck(PregnancyCheck pregnancyCheck) {
        this.pregnancyCheck = pregnancyCheck;
    }

    @Override
	public String toString() {
		return "Pregnancy [pcid=" + pcid + ", mname=" + mname + ", mage=" + mage + ", pcdate=" + pcdate + ", location="
				+ location + ", sibship=" + sibship + ", menstrualcycle=" + menstrualcycle + ", oneage=" + oneage
				+ ", quantity=" + quantity + ", dysmenorrhea=" + dysmenorrhea + ", holdtime=" + holdtime
				+ ", lifestyle=" + lifestyle + ", favorsport=" + favorsport + ", dosport=" + dosport + ", sporttime="
				+ sporttime + ", sportpower=" + sportpower + ", familyrelation=" + familyrelation + ", workship="
				+ workship + ", friendship=" + friendship + ", ready=" + ready + ", pressure=" + pressure
				+ ", folicacid=" + folicacid + ", medicine=" + medicine + ", meet=" + meet + ", fruits=" + fruits
				+ ", vegetables=" + vegetables + ", pickyeater=" + pickyeater + ", hostileeenvironment="
				+ hostileeenvironment + ", vaccinate=" + vaccinate + ", familyhistory=" + familyhistory
				+ ", recentmarriage=" + recentmarriage + ", mentalstate=" + mentalstate + "]";
	}
    
}