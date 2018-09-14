package cn.yunji.doctormanager.entity;

public class Food {
    private Integer foodid;

    private String foodname;

    private String attribute;

    private String pyramidlayer;

    private String effect;

    private String taboo;
    
    private String picture;

    private String filtercondition;

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    public String getPyramidlayer() {
        return pyramidlayer;
    }

    public void setPyramidlayer(String pyramidlayer) {
        this.pyramidlayer = pyramidlayer == null ? null : pyramidlayer.trim();
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect == null ? null : effect.trim();
    }

    public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo == null ? null : taboo.trim();
    }

    public String getFiltercondition() {
        return filtercondition;
    }

    public void setFiltercondition(String filtercondition) {
        this.filtercondition = filtercondition == null ? null : filtercondition.trim();
    }
}