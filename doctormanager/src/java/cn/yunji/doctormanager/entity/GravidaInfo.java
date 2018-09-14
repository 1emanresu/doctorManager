package cn.yunji.doctormanager.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class GravidaInfo {
	private List<WeightTest> weightTestList;
	
    private String mid;

    private Integer userid;

    private String hospitalid;
    
    private String bhospitalid;//建档医院id
    
    private String fhospitalid; //关注医院id

    private Integer ghigh;

    private String gname;

    private String birthcertificate;
  
    private String monthpresidenceaddress;

    private String monthpresentaddress;
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date expectedconfinement; 
    
    private Integer medicalcardtype;

    private Integer preparer;
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date recorddate;

    private String recordno;

    private Integer registertype;

    private Integer attribution;

    private Integer doctor;
    
    private Integer vipGradeid;

	public Integer getVipGradeid() {
		return vipGradeid;
	}

	public void setVipGradeid(Integer vipGradeid) {
		this.vipGradeid = vipGradeid;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date enddate;
    
	//建档孕周
    private Integer weeks;
    
    //怀孕状态
    private Integer pergnancystatus;

	/**
     * @author wangzw
     * 添加3个字段
     */
    private Integer patienttypeid;

    private String medicalrecordno;

    private Integer processingState;
    
    private String pregnancyBirth;
    private List<FamilyMember> familyMemberList;
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date birthYears;
	/**
	 * @author hongwx
	 * 添加以下字段
	 */
	private String distance;
	private Integer husband_condition;
	private Integer poor;
	private Integer family_gdp;
	private Integer postalcode;
	private Integer household_register;
	private Integer town;
	private String domicile;
	private String wedlock;
	private Integer marry_age;
	private Integer inoculation_history;
	private String medical_insurance;
	private String agricultural;
	
	/**
     * @author yinzx  2017/9/20
     * 添加以下2个字段advicestate  weeklystate
     */
    private Integer advicestate;
    private Integer weeklystate;
    
	private List<Abnormityinfo> abnormityinfoList;
	
	public List<Abnormityinfo> getAbnormityinfoList() {
		return abnormityinfoList;
	}

	public void setAbnormityinfoList(List<Abnormityinfo> abnormityinfoList) {
		this.abnormityinfoList = abnormityinfoList;
	}

	private Integer count;
	
	public Integer getPergnancystatus() {
		return pergnancystatus;
	}

	public void setPergnancystatus(Integer pergnancystatus) {
		this.pergnancystatus = pergnancystatus;
	}
    
    
	public String getFhospitalid() {
		return fhospitalid;
	}

	public void setFhospitalid(String fhospitalid) {
		this.fhospitalid = fhospitalid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getBirthYears() {
		return birthYears;
	}

	public void setBirthYears(Date birthYears) {
		this.birthYears = birthYears;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Integer getHusband_condition() {
		return husband_condition;
	}

	public void setHusband_condition(Integer husband_condition) {
		this.husband_condition = husband_condition;
	}

	public Integer getPoor() {
		return poor;
	}

	public void setPoor(Integer poor) {
		this.poor = poor;
	}

	public Integer getFamily_gdp() {
		return family_gdp;
	}

	public void setFamily_gdp(Integer family_gdp) {
		this.family_gdp = family_gdp;
	}

	public Integer getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(Integer postalcode) {
		this.postalcode = postalcode;
	}

	public Integer getHousehold_register() {
		return household_register;
	}

	public void setHousehold_register(Integer household_register) {
		this.household_register = household_register;
	}

	public Integer getTown() {
		return town;
	}

	public void setTown(Integer town) {
		this.town = town;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getWedlock() {
		return wedlock;
	}

	public void setWedlock(String wedlock) {
		this.wedlock = wedlock;
	}

	public Integer getMarry_age() {
		return marry_age;
	}

	public void setMarry_age(Integer marry_age) {
		this.marry_age = marry_age;
	}

	public Integer getInoculation_history() {
		return inoculation_history;
	}

	public void setInoculation_history(Integer inoculation_history) {
		this.inoculation_history = inoculation_history;
	}

	public String getMedical_insurance() {
		return medical_insurance;
	}

	public void setMedical_insurance(String medical_insurance) {
		this.medical_insurance = medical_insurance;
	}

	public String getAgricultural() {
		return agricultural;
	}

	public void setAgricultural(String agricultural) {
		this.agricultural = agricultural;
	}

	public String getPregnancyBirth() {
		return pregnancyBirth;
	}

	public void setPregnancyBirth(String pregnancyBirth) {
		this.pregnancyBirth = pregnancyBirth;
	}

	public Integer getProcessingState() {
		return processingState;
	}

	public void setProcessingState(Integer processingState) {
		this.processingState = processingState;
	}

	public Integer getPatienttypeid() {
		return patienttypeid;
	}

	public void setPatienttypeid(Integer patienttypeid) {
		this.patienttypeid = patienttypeid;
	}

	public String getMedicalrecordno() {
		return medicalrecordno;
	}

	public void setMedicalrecordno(String medicalrecordno) {
		this.medicalrecordno = medicalrecordno;
	}

 
	public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid == null ? null : hospitalid.trim();
    }

    public Integer getGhigh() {
        return ghigh;
    }

    public void setGhigh(Integer ghigh) {
        this.ghigh = ghigh;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getBirthcertificate() {
        return birthcertificate;
    }

    public void setBirthcertificate(String birthcertificate) {
        this.birthcertificate = birthcertificate == null ? null : birthcertificate.trim();
    }

    public String getMonthpresidenceaddress() {
        return monthpresidenceaddress;
    }

    public void setMonthpresidenceaddress(String monthpresidenceaddress) {
        this.monthpresidenceaddress = monthpresidenceaddress == null ? null : monthpresidenceaddress.trim();
    }

    public String getMonthpresentaddress() {
        return monthpresentaddress;
    }

    public void setMonthpresentaddress(String monthpresentaddress) {
        this.monthpresentaddress = monthpresentaddress == null ? null : monthpresentaddress.trim();
    }

    public Date getExpectedconfinement() {
        return expectedconfinement;
    }

    public void setExpectedconfinement(Date expectedconfinement) {
        this.expectedconfinement = expectedconfinement;
    }

    public Integer getPreparer() {
        return preparer;
    }

    public void setPreparer(Integer preparer) {
        this.preparer = preparer;
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public String getRecordno() {
        return recordno;
    }

    public void setRecordno(String recordno) {
        this.recordno = recordno == null ? null : recordno.trim();
    }

    public Integer getRegistertype() {
        return registertype;
    }

    public void setRegistertype(Integer registertype) {
        this.registertype = registertype;
    }

    public Integer getAttribution() {
        return attribution;
    }

    public void setAttribution(Integer attribution) {
        this.attribution = attribution;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

	public List<WeightTest> getWeightTestList() {
		return weightTestList;
	}

	public void setWeightTestList(List<WeightTest> weightTestList) {
		this.weightTestList = weightTestList;
	}

	public Integer getWeeks() {
		return weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}

	public List<FamilyMember> getFamilyMemberList() {
		return familyMemberList;
	}

	public void setFamilyMemberList(List<FamilyMember> familyMemberList) {
		this.familyMemberList = familyMemberList;
	}


	public Integer getAdvicestate() {
        return advicestate;
    }

    public void setAdvicestate(Integer advicestate) {
        this.advicestate = advicestate;
    }

    public Integer getWeeklystate() {
        return weeklystate;
    }

    public void setWeeklystate(Integer weeklystate) {
        this.weeklystate = weeklystate;
    }

    @Override
	public String toString() {
		return "GravidaInfo [weightTestList=" + weightTestList + ", mid=" + mid + ", userid=" + userid + ", hospitalid="
				+ hospitalid + ", bhospitalid=" + bhospitalid + ", ghigh=" + ghigh + ", gname=" + gname
				+ ", birthcertificate=" + birthcertificate + ", monthpresidenceaddress=" + monthpresidenceaddress
				+ ", monthpresentaddress=" + monthpresentaddress + ", expectedconfinement=" + expectedconfinement
				+ ", medicalcardtype=" + medicalcardtype + ", preparer=" + preparer + ", recorddate=" + recorddate
				+ ", recordno=" + recordno + ", registertype=" + registertype + ", attribution=" + attribution
				+ ", doctor=" + doctor + ", enddate=" + enddate + ", weeks=" + weeks + ", pergnancystatus="
				+ pergnancystatus + ", patienttypeid=" + patienttypeid + ", medicalrecordno=" + medicalrecordno
				+ ", processingState=" + processingState + ", pregnancyBirth="
				+ pregnancyBirth + ", familyMemberList=" + familyMemberList + ", birthYears=" + birthYears
				+ ", distance=" + distance + ", husband_condition=" + husband_condition + ", poor=" + poor
				+ ", family_gdp=" + family_gdp + ", postalcode=" + postalcode + ", household_register="
				+ household_register + ", town=" + town + ", domicile=" + domicile + ", wedlock=" + wedlock
				+ ", marry_age=" + marry_age + ", inoculation_history=" + inoculation_history + ", medical_insurance="
				+ medical_insurance + ", agricultural=" + agricultural + ", count=" + count + "]";
	}

	

	public Integer getMedicalcardtype() {
		return medicalcardtype;
	}

	public void setMedicalcardtype(Integer medicalcardtype) {
		this.medicalcardtype = medicalcardtype;
	}

	/**
	 * @return the bhospitalid
	 */
	public String getBhospitalid() {
		return bhospitalid;
	}

	/**
	 * @param bhospitalid the bhospitalid to set
	 */
	public void setBhospitalid(String bhospitalid) {
		this.bhospitalid = bhospitalid;
	}
}