package cn.yunji.doctormanager.entity;

public class PregnancyHistory {
    private Integer phid;

    private String mid;

    private Integer gravidity;

    private Integer parity;

    private Integer stillbirth;

    private Integer oaf;

    private Integer mature;

    private Integer prematurebirth;

    private Integer abortion;

    private Integer children;
    
    /**
     * @author  wangzw
     * 添加6个字段
     */
    private Integer heart;
    private Integer lung;
    private Integer vulva;
    private Integer cervixUteri;
    private Integer uterus;
    private Integer vagina;

	private Integer abdominal;
    
    public Integer getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(Integer abdominal) {
		this.abdominal = abdominal;
	}

	public Integer getHeart() {
		return heart;
	}

	public void setHeart(Integer heart) {
		this.heart = heart;
	}

	public Integer getLung() {
		return lung;
	}

	public void setLung(Integer lung) {
		this.lung = lung;
	}

	public Integer getVulva() {
		return vulva;
	}

	public void setVulva(Integer vulva) {
		this.vulva = vulva;
	}

	public Integer getCervixUteri() {
		return cervixUteri;
	}

	public void setCervixUteri(Integer cervixUteri) {
		this.cervixUteri = cervixUteri;
	}

	public Integer getUterus() {
		return uterus;
	}

	public void setUterus(Integer uterus) {
		this.uterus = uterus;
	}

	public Integer getVagina() {
		return vagina;
	}

	public void setVagina(Integer vagina) {
		this.vagina = vagina;
	}

	public Integer getPhid() {
        return phid;
    }

    public void setPhid(Integer phid) {
        this.phid = phid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getGravidity() {
        return gravidity;
    }

    public void setGravidity(Integer gravidity) {
        this.gravidity = gravidity;
    }

    public Integer getParity() {
        return parity;
    }

    public void setParity(Integer parity) {
        this.parity = parity;
    }

    public Integer getStillbirth() {
        return stillbirth;
    }

    public void setStillbirth(Integer stillbirth) {
        this.stillbirth = stillbirth;
    }

    public Integer getOaf() {
        return oaf;
    }

    public void setOaf(Integer oaf) {
        this.oaf = oaf;
    }

    public Integer getMature() {
        return mature;
    }

    public void setMature(Integer mature) {
        this.mature = mature;
    }

    public Integer getPrematurebirth() {
        return prematurebirth;
    }

    public void setPrematurebirth(Integer prematurebirth) {
        this.prematurebirth = prematurebirth;
    }

    public Integer getAbortion() {
        return abortion;
    }

    public void setAbortion(Integer abortion) {
        this.abortion = abortion;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}