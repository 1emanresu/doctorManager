package cn.yunji.doctormanager.entity;

public class DietaryHabit {
    private Integer hid;

    private String mid;

    private String badhabit;

    private String goodhabit;
    
    private Integer count;
    

    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getBadhabit() {
        return badhabit;
    }

    public void setBadhabit(String badhabit) {
        this.badhabit = badhabit == null ? null : badhabit.trim();
    }

    public String getGoodhabit() {
        return goodhabit;
    }

    public void setGoodhabit(String goodhabit) {
        this.goodhabit = goodhabit == null ? null : goodhabit.trim();
    }
}