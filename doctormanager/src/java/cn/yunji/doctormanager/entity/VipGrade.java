package cn.yunji.doctormanager.entity;

import java.math.BigDecimal;
import java.util.Date;

public class VipGrade {
    private Integer vipgradeid;

    private String vipgradename;

    private String vipintroduce;

    private Integer diagnosistimes;

    private BigDecimal vipprices;

    private Integer weeklytimes;

    private Date vipbegindate;

    private Date vipenddate;

    private String projectdetail;
    
    private Integer usetimes;
    
    private Integer price;
    
    private String handletips;
    
    private String instructions;
    
    private Integer count;
    
    
    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getProjectdetail() {
		return projectdetail;
	}

	public void setProjectdetail(String projectdetail) {
		this.projectdetail = projectdetail;
	}

	public Integer getUsetimes() {
		return usetimes;
	}

	public void setUsetimes(Integer usetimes) {
		this.usetimes = usetimes;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getHandletips() {
		return handletips;
	}

	public void setHandletips(String handletips) {
		this.handletips = handletips;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Integer getVipgradeid() {
        return vipgradeid;
    }

    public void setVipgradeid(Integer vipgradeid) {
        this.vipgradeid = vipgradeid;
    }

    public String getVipgradename() {
        return vipgradename;
    }

    public void setVipgradename(String vipgradename) {
        this.vipgradename = vipgradename == null ? null : vipgradename.trim();
    }

    public String getVipintroduce() {
        return vipintroduce;
    }

    public void setVipintroduce(String vipintroduce) {
        this.vipintroduce = vipintroduce == null ? null : vipintroduce.trim();
    }

    public Integer getDiagnosistimes() {
        return diagnosistimes;
    }

    public void setDiagnosistimes(Integer diagnosistimes) {
        this.diagnosistimes = diagnosistimes;
    }

    public BigDecimal getVipprices() {
        return vipprices;
    }

    public void setVipprices(BigDecimal vipprices) {
        this.vipprices = vipprices;
    }

    public Integer getWeeklytimes() {
        return weeklytimes;
    }

    public void setWeeklytimes(Integer weeklytimes) {
        this.weeklytimes = weeklytimes;
    }

    public Date getVipbegindate() {
        return vipbegindate;
    }

    public void setVipbegindate(Date vipbegindate) {
        this.vipbegindate = vipbegindate;
    }

    public Date getVipenddate() {
        return vipenddate;
    }

    public void setVipenddate(Date vipenddate) {
        this.vipenddate = vipenddate;
    }

	@Override
	public String toString() {
		return "VipGrade [vipgradeid=" + vipgradeid + ", vipgradename=" + vipgradename + ", vipintroduce="
				+ vipintroduce + ", diagnosistimes=" + diagnosistimes + ", vipprices=" + vipprices + ", weeklytimes="
				+ weeklytimes + ", vipbegindate=" + vipbegindate + ", vipenddate=" + vipenddate + ", projectdetail="
				+ projectdetail + ", usetimes=" + usetimes + ", price=" + price + ", handletips=" + handletips
				+ ", instructions=" + instructions + "]";
	}
    
}