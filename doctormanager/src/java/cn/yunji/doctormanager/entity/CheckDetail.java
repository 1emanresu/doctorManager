package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;

public class CheckDetail {
    private Integer checkdetailid;

    private Integer cid;

    private Integer checkresultid;

    private BigDecimal checkvalue;
    
    private String symbol;
    
    private Checkindex checkindex;
    
    private String description;
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCheckdetailid() {
        return checkdetailid;
    }

    public void setCheckdetailid(Integer checkdetailid) {
        this.checkdetailid = checkdetailid;
    }

    public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCheckresultid() {
        return checkresultid;
    }

    public void setCheckresultid(Integer checkresultid) {
        this.checkresultid = checkresultid;
    }

    public BigDecimal getCheckvalue() {
        return checkvalue;
    }

    public void setCheckvalue(BigDecimal checkvalue) {
        this.checkvalue = checkvalue;
    }
	public Checkindex getCheckindex() {
		return checkindex;
	}

	public void setCheckindex(Checkindex checkindex) {
		this.checkindex = checkindex;
	}
}