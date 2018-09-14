package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reminder {
    private Integer rid;

    private String mid;

    private Integer doctorid;

    private Integer daid;

    private String sendingways;

    private String acceptedpeople;

    private String selftestdetails;
    
    private String monitoringsuggestion;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date uploadDate;
    
    private String remindcontent;
    
    private String remindname;
    
    private String reportReminder;
    
    private Integer count;
    
    
    public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getReportReminder() {
		return reportReminder;
	}

	public void setReportReminder(String reportReminder) {
		this.reportReminder = reportReminder;
	}

	public String getRemindname() {
		return remindname;
	}

	public void setRemindname(String remindname) {
		this.remindname = remindname;
	}

	public String getRemindcontent() {
		return remindcontent;
	}

	public void setRemindcontent(String remindcontent) {
		this.remindcontent = remindcontent;
	}

	public String getMonitoringsuggestion() {
		return monitoringsuggestion;
	}

	public void setMonitoringsuggestion(String monitoringsuggestion) {
		this.monitoringsuggestion = monitoringsuggestion;
	}

	public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public Integer getDaid() {
        return daid;
    }

    public void setDaid(Integer daid) {
        this.daid = daid;
    }

    public String getSendingways() {
        return sendingways;
    }

    public void setSendingways(String sendingways) {
        this.sendingways = sendingways == null ? null : sendingways.trim();
    }

    public String getAcceptedpeople() {
        return acceptedpeople;
    }

    public void setAcceptedpeople(String acceptedpeople) {
        this.acceptedpeople = acceptedpeople == null ? null : acceptedpeople.trim();
    }

    public String getSelftestdetails() {
        return selftestdetails;
    }

    public void setSelftestdetails(String selftestdetails) {
        this.selftestdetails = selftestdetails == null ? null : selftestdetails.trim();
    }

	@Override
	public String toString() {
		return "Reminder [rid=" + rid + ", mid=" + mid + ", doctorid=" + doctorid + ", daid=" + daid + ", sendingways="
				+ sendingways + ", acceptedpeople=" + acceptedpeople + ", selftestdetails=" + selftestdetails
				+ ", monitoringsuggestion=" + monitoringsuggestion + ", uploadDate=" + uploadDate + ", remindcontent="
				+ remindcontent + ", remindname=" + remindname + ", reportReminder=" + reportReminder + ", count="
				+ count + "]";
	}

	
    
}