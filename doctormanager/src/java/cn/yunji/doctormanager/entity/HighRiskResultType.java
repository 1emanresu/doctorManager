package cn.yunji.doctormanager.entity;

public class HighRiskResultType {
    private Integer highriskresulttypeid;

    private String highriskresulttype;

    private Integer highriskscore;
    
    private Integer stratValue;

    public Integer getStratValue() {
		return stratValue;
	}

	public void setStratValue(Integer stratValue) {
		this.stratValue = stratValue;
	}

	public Integer getHighriskresulttypeid() {
        return highriskresulttypeid;
    }

    public void setHighriskresulttypeid(Integer highriskresulttypeid) {
        this.highriskresulttypeid = highriskresulttypeid;
    }

    public String getHighriskresulttype() {
        return highriskresulttype;
    }

    public void setHighriskresulttype(String highriskresulttype) {
        this.highriskresulttype = highriskresulttype == null ? null : highriskresulttype.trim();
    }

    public Integer getHighriskscore() {
        return highriskscore;
    }

    public void setHighriskscore(Integer highriskscore) {
        this.highriskscore = highriskscore;
    }
}