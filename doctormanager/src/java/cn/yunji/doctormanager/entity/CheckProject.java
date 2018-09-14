package cn.yunji.doctormanager.entity;

public class CheckProject {
    private Integer checkprojectid;

    private String riskname;

    private Integer froms;
    
    private Integer checkType;

    public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public Integer getCheckprojectid() {
        return checkprojectid;
    }

    public void setCheckprojectid(Integer checkprojectid) {
        this.checkprojectid = checkprojectid;
    }

    public String getRiskname() {
        return riskname;
    }

    public void setRiskname(String riskname) {
        this.riskname = riskname == null ? null : riskname.trim();
    }

    public Integer getFroms() {
        return froms;
    }

    public void setFroms(Integer froms) {
        this.froms = froms;
    }
}