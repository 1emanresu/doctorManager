package cn.yunji.doctormanager.entity;

import java.util.Date;

public class Antenatalcaretime {
    private Integer aid;

    private String mid;

    private Date firstantenatalcaretime;

    private Date secondantenatalcaretime;

    private Date thirdantenatalcaretime;

    private Date forthantenatalcaretime;

    private Date fifthantenatalcaretime;

    private Date sixthantenatalcaretime;

    private Date seventhantenatalcaretime;
    
    private String firstExtendCheckprojectId;
    
    private String secondExtendCheckprojectId;

	private String thirdExtendCheckprojectId;
    
    private String fourthExtendCheckprojectId;
    
    private String fifthExtendCheckprojectId;
    
    private String sixthExtendCheckprojectId;
    
    private String sevenExtendCheckprojectId;
    
    public String getFirstExtendCheckprojectId() {
		return firstExtendCheckprojectId;
	}

	public void setFirstExtendCheckprojectId(String firstExtendCheckprojectId) {
		this.firstExtendCheckprojectId = firstExtendCheckprojectId;
	}

	public String getSecondExtendCheckprojectId() {
		return secondExtendCheckprojectId;
	}

	public void setSecondExtendCheckprojectId(String secondExtendCheckprojectId) {
		this.secondExtendCheckprojectId = secondExtendCheckprojectId;
	}

	public String getThirdExtendCheckprojectId() {
		return thirdExtendCheckprojectId;
	}

	public void setThirdExtendCheckprojectId(String thirdExtendCheckprojectId) {
		this.thirdExtendCheckprojectId = thirdExtendCheckprojectId;
	}

	public String getFourthExtendCheckprojectId() {
		return fourthExtendCheckprojectId;
	}

	public void setFourthExtendCheckprojectId(String fourthExtendCheckprojectId) {
		this.fourthExtendCheckprojectId = fourthExtendCheckprojectId;
	}

	public String getFifthExtendCheckprojectId() {
		return fifthExtendCheckprojectId;
	}

	public void setFifthExtendCheckprojectId(String fifthExtendCheckprojectId) {
		this.fifthExtendCheckprojectId = fifthExtendCheckprojectId;
	}

	public String getSixthExtendCheckprojectId() {
		return sixthExtendCheckprojectId;
	}

	public void setSixthExtendCheckprojectId(String sixthExtendCheckprojectId) {
		this.sixthExtendCheckprojectId = sixthExtendCheckprojectId;
	}

	public String getSevenExtendCheckprojectId() {
		return sevenExtendCheckprojectId;
	}

	public void setSevenExtendCheckprojectId(String sevenExtendCheckprojectId) {
		this.sevenExtendCheckprojectId = sevenExtendCheckprojectId;
	}

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getFirstantenatalcaretime() {
        return firstantenatalcaretime;
    }

    public void setFirstantenatalcaretime(Date firstantenatalcaretime) {
        this.firstantenatalcaretime = firstantenatalcaretime;
    }

    public Date getSecondantenatalcaretime() {
        return secondantenatalcaretime;
    }

    public void setSecondantenatalcaretime(Date secondantenatalcaretime) {
        this.secondantenatalcaretime = secondantenatalcaretime;
    }

    public Date getThirdantenatalcaretime() {
        return thirdantenatalcaretime;
    }

    public void setThirdantenatalcaretime(Date thirdantenatalcaretime) {
        this.thirdantenatalcaretime = thirdantenatalcaretime;
    }

    public Date getForthantenatalcaretime() {
        return forthantenatalcaretime;
    }

    public void setForthantenatalcaretime(Date forthantenatalcaretime) {
        this.forthantenatalcaretime = forthantenatalcaretime;
    }

    public Date getFifthantenatalcaretime() {
        return fifthantenatalcaretime;
    }

    public void setFifthantenatalcaretime(Date fifthantenatalcaretime) {
        this.fifthantenatalcaretime = fifthantenatalcaretime;
    }

    public Date getSixthantenatalcaretime() {
        return sixthantenatalcaretime;
    }

    public void setSixthantenatalcaretime(Date sixthantenatalcaretime) {
        this.sixthantenatalcaretime = sixthantenatalcaretime;
    }

    public Date getSeventhantenatalcaretime() {
        return seventhantenatalcaretime;
    }

    public void setSeventhantenatalcaretime(Date seventhantenatalcaretime) {
        this.seventhantenatalcaretime = seventhantenatalcaretime;
    }

    @Override
    public String toString() {
        return "Antenatalcaretime [aid=" + aid + ", mid=" + mid + ", firstantenatalcaretime=" + firstantenatalcaretime
                + ", secondantenatalcaretime=" + secondantenatalcaretime + ", thirdantenatalcaretime="
                + thirdantenatalcaretime + ", forthantenatalcaretime=" + forthantenatalcaretime
                + ", fifthantenatalcaretime=" + fifthantenatalcaretime + ", sixthantenatalcaretime="
                + sixthantenatalcaretime + ", seventhantenatalcaretime=" + seventhantenatalcaretime
                + ", firstExtendCheckprojectId=" + firstExtendCheckprojectId + ", secondExtendCheckprojectId="
                + secondExtendCheckprojectId + ", thirdExtendCheckprojectId=" + thirdExtendCheckprojectId
                + ", fourthExtendCheckprojectId=" + fourthExtendCheckprojectId + ", fifthExtendCheckprojectId="
                + fifthExtendCheckprojectId + ", sixthExtendCheckprojectId=" + sixthExtendCheckprojectId
                + ", sevenExtendCheckprojectId=" + sevenExtendCheckprojectId + "]";
    }
}