package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Prescription {
    private Integer preid;

    private String mid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date predate;

    private String medicinefrom;

    private String medicinename;

    private String dose;

    private String medicinenumber;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startdate;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enddate;

    private String duration;

    private String medicinepic;

    private String prepic;

    private String method;

    public Integer getPreid() {
        return preid;
    }

    public void setPreid(Integer preid) {
        this.preid = preid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public Date getPredate() {
		return predate;
	}

	public void setPredate(Date predate) {
		this.predate = predate;
	}

	public String getMedicinefrom() {
        return medicinefrom;
    }

    public void setMedicinefrom(String medicinefrom) {
        this.medicinefrom = medicinefrom == null ? null : medicinefrom.trim();
    }

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename == null ? null : medicinename.trim();
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose == null ? null : dose.trim();
    }

    public String getMedicinenumber() {
        return medicinenumber;
    }

    public void setMedicinenumber(String medicinenumber) {
        this.medicinenumber = medicinenumber == null ? null : medicinenumber.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getMedicinepic() {
        return medicinepic;
    }

    public void setMedicinepic(String medicinepic) {
        this.medicinepic = medicinepic == null ? null : medicinepic.trim();
    }

    public String getPrepic() {
        return prepic;
    }

    public void setPrepic(String prepic) {
        this.prepic = prepic == null ? null : prepic.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }
}