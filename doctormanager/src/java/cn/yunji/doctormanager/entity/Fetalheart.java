package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Fetalheart {
    private Integer fid;

    private String mid;

    private Integer checkprojectid;

    private String hospitalname;

    private Integer sbloodpressure;

    private Integer dbloodpressure;

    private Integer abloodpressure;

    private BigDecimal oxygensaturation;

    private Integer frateline;
    
    private Integer sleepwakecycle;
    
    private Integer waveshape;

    private Integer fetalmovements;

    private Integer aperiodicacceleration;

    private Integer periodicacceleration;

    private Integer apparentacceleration;

    private Integer ed;

    private Integer ld;

    private Integer pd;

    private Integer svd;

    private Integer mvd;

    private Integer cytometaplasia;

    private Integer contractions;

    private Integer weeks;
    
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkdate;

    private Integer famplitude;

    private Integer facceltim;

    private Integer faccelamplitude;
    
    private String description;
    
    private Integer fhrchange;
    
    private Integer fhrtimes;
    //胎心异常信息列表
    private List<FetalException> flList=new ArrayList<>();

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getSleepwakecycle() {
		return sleepwakecycle;
	}

	public void setSleepwakecycle(Integer sleepwakecycle) {
		this.sleepwakecycle = sleepwakecycle;
	}

	public Integer getWaveshape() {
		return waveshape;
	}

	public void setWaveshape(Integer waveshape) {
		this.waveshape = waveshape;
	}

	public Integer getCheckprojectid() {
        return checkprojectid;
    }

    public void setCheckprojectid(Integer checkprojectid) {
        this.checkprojectid = checkprojectid;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname == null ? null : hospitalname.trim();
    }

    public Integer getSbloodpressure() {
        return sbloodpressure;
    }

    public void setSbloodpressure(Integer sbloodpressure) {
        this.sbloodpressure = sbloodpressure;
    }

    public Integer getDbloodpressure() {
        return dbloodpressure;
    }

    public void setDbloodpressure(Integer dbloodpressure) {
        this.dbloodpressure = dbloodpressure;
    }

    public Integer getAbloodpressure() {
        return abloodpressure;
    }

    public void setAbloodpressure(Integer abloodpressure) {
        this.abloodpressure = abloodpressure;
    }

    public BigDecimal getOxygensaturation() {
        return oxygensaturation;
    }

    public void setOxygensaturation(BigDecimal oxygensaturation) {
        this.oxygensaturation = oxygensaturation;
    }

    public Integer getFrateline() {
        return frateline;
    }

    public void setFrateline(Integer frateline) {
        this.frateline = frateline;
    }

    public Integer getFetalmovements() {
        return fetalmovements;
    }

    public void setFetalmovements(Integer fetalmovements) {
        this.fetalmovements = fetalmovements;
    }

    public Integer getAperiodicacceleration() {
        return aperiodicacceleration;
    }

    public void setAperiodicacceleration(Integer aperiodicacceleration) {
        this.aperiodicacceleration = aperiodicacceleration;
    }

    public Integer getPeriodicacceleration() {
        return periodicacceleration;
    }

    public void setPeriodicacceleration(Integer periodicacceleration) {
        this.periodicacceleration = periodicacceleration;
    }

    public Integer getApparentacceleration() {
        return apparentacceleration;
    }

    public void setApparentacceleration(Integer apparentacceleration) {
        this.apparentacceleration = apparentacceleration;
    }

    public Integer getEd() {
        return ed;
    }

    public void setEd(Integer ed) {
        this.ed = ed;
    }

    public Integer getLd() {
        return ld;
    }

    public void setLd(Integer ld) {
        this.ld = ld;
    }

    public Integer getPd() {
        return pd;
    }

    public void setPd(Integer pd) {
        this.pd = pd;
    }

    public Integer getSvd() {
        return svd;
    }

    public void setSvd(Integer svd) {
        this.svd = svd;
    }

    public Integer getMvd() {
        return mvd;
    }

    public void setMvd(Integer mvd) {
        this.mvd = mvd;
    }

    public Integer getCytometaplasia() {
        return cytometaplasia;
    }

    public void setCytometaplasia(Integer cytometaplasia) {
        this.cytometaplasia = cytometaplasia;
    }

    public Integer getContractions() {
        return contractions;
    }

    public void setContractions(Integer contractions) {
        this.contractions = contractions;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Integer getFamplitude() {
        return famplitude;
    }

    public void setFamplitude(Integer famplitude) {
        this.famplitude = famplitude;
    }

    public Integer getFacceltim() {
        return facceltim;
    }

    public void setFacceltim(Integer facceltim) {
        this.facceltim = facceltim;
    }

    public Integer getFaccelamplitude() {
        return faccelamplitude;
    }

    public void setFaccelamplitude(Integer faccelamplitude) {
        this.faccelamplitude = faccelamplitude;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FetalException> getFlList() {
		return flList;
	}

	public void setFlList(List<FetalException> flList) {
		this.flList = flList;
	}

	/**
	 * @return the fhrchange
	 */
	public Integer getFhrchange() {
		return fhrchange;
	}

	/**
	 * @param fhrchange the fhrchange to set
	 */
	public void setFhrchange(Integer fhrchange) {
		this.fhrchange = fhrchange;
	}

	/**
	 * @return the fhrtimes
	 */
	public Integer getFhrtimes() {
		return fhrtimes;
	}

	/**
	 * @param fhrtimes the fhrtimes to set
	 */
	public void setFhrtimes(Integer fhrtimes) {
		this.fhrtimes = fhrtimes;
	}

	

}