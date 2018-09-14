package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;

public class Checkindex {
    private Integer cid;

    private Integer checkprojectid;

    private String cname;

    private BigDecimal cbegin;

    private BigDecimal cend;

    private String cunit;
    
    private String shortname;
    
    private String referencevalue;
    
    private String hospitalid;
    
    public String getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}

	public String getReferencevalue() {
		return referencevalue;
	}

	public void setReferencevalue(String referencevalue) {
		this.referencevalue = referencevalue;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCheckprojectid() {
        return checkprojectid;
    }

    public void setCheckprojectid(Integer checkprojectid) {
        this.checkprojectid = checkprojectid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public BigDecimal getCbegin() {
        return cbegin;
    }

    public void setCbegin(BigDecimal cbegin) {
        this.cbegin = cbegin;
    }

    public BigDecimal getCend() {
        return cend;
    }

    public void setCend(BigDecimal cend) {
        this.cend = cend;
    }

    public String getCunit() {
        return cunit;
    }

    public void setCunit(String cunit) {
        this.cunit = cunit == null ? null : cunit.trim();
    }  
}