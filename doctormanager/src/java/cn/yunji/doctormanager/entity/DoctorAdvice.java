package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DoctorAdvice {
    private Integer daid;

    private String mid;

    private Integer doctorid;

    private Integer abnormityid;
    
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date advicedate;

    private String myknowledge;
    
    private int count;
    
    private String prescriptionimg;
    
    public String getPrescriptionimg() {
		return prescriptionimg;
	}

	public void setPrescriptionimg(String prescriptionimg) {
		this.prescriptionimg = prescriptionimg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Integer getDaid() {
        return daid;
    }

    public void setDaid(Integer daid) {
        this.daid = daid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Date getAdvicedate() {
        return advicedate;
    }

    public Integer getAbnormityid() {
		return abnormityid;
	}

	public void setAbnormityid(Integer abnormityid) {
		this.abnormityid = abnormityid;
	}
	
    public void setAdvicedate(Date advicedate) {
        this.advicedate = advicedate;
    }

    public String getMyknowledge() {
        return myknowledge;
    }

    public void setMyknowledge(String myknowledge) {
        this.myknowledge = myknowledge == null ? null : myknowledge.trim();
    }

	@Override
	public String toString() {
		return "DoctorAdvice [daid=" + daid + ", mid=" + mid + ", doctorid=" + doctorid + ", abnormityid=" + abnormityid
				+ ", advicedate=" + advicedate + ", myknowledge=" + myknowledge + ", count=" + count + "]";
	}
    
}