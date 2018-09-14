package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HighrisktestResult {
    private Integer highrisktestresultid;

    private String mid;

    private String resultcontent;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
   	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date resultdate;

    private Integer sunscore;

    public Integer getHighrisktestresultid() {
        return highrisktestresultid;
    }

    public void setHighrisktestresultid(Integer highrisktestresultid) {
        this.highrisktestresultid = highrisktestresultid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getResultcontent() {
        return resultcontent;
    }

    public void setResultcontent(String resultcontent) {
        this.resultcontent = resultcontent == null ? null : resultcontent.trim();
    }

    public Date getResultdate() {
        return resultdate;
    }

    public void setResultdate(Date resultdate) {
        this.resultdate = resultdate;
    }

    public Integer getSunscore() {
        return sunscore;
    }

    public void setSunscore(Integer sunscore) {
        this.sunscore = sunscore;
    }

	@Override
	public String toString() {
		return "HighrisktestResult [highrisktestresultid=" + highrisktestresultid + ", mid=" + mid + ", resultcontent="
				+ resultcontent + ", resultdate=" + resultdate + ", sunscore=" + sunscore + "]";
	}
    
}