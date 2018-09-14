package cn.yunji.doctormanager.entity;

public class NutritionalSupplements {
    private Integer id;

    private String nutritionname;

    private String nutritioneffect;

    private String nutritionbrand;

    private String richinfood;

    private String mattersneedingattention;

    private String howtoadd;

    private String filtercondition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNutritionname() {
        return nutritionname;
    }

    public void setNutritionname(String nutritionname) {
        this.nutritionname = nutritionname == null ? null : nutritionname.trim();
    }

    public String getNutritioneffect() {
        return nutritioneffect;
    }

    public void setNutritioneffect(String nutritioneffect) {
        this.nutritioneffect = nutritioneffect == null ? null : nutritioneffect.trim();
    }

    public String getNutritionbrand() {
        return nutritionbrand;
    }

    public void setNutritionbrand(String nutritionbrand) {
        this.nutritionbrand = nutritionbrand == null ? null : nutritionbrand.trim();
    }

    public String getRichinfood() {
        return richinfood;
    }

    public void setRichinfood(String richinfood) {
        this.richinfood = richinfood == null ? null : richinfood.trim();
    }

    public String getMattersneedingattention() {
        return mattersneedingattention;
    }

    public void setMattersneedingattention(String mattersneedingattention) {
        this.mattersneedingattention = mattersneedingattention == null ? null : mattersneedingattention.trim();
    }

    public String getHowtoadd() {
        return howtoadd;
    }

    public void setHowtoadd(String howtoadd) {
        this.howtoadd = howtoadd == null ? null : howtoadd.trim();
    }

    public String getFiltercondition() {
        return filtercondition;
    }

    public void setFiltercondition(String filtercondition) {
        this.filtercondition = filtercondition == null ? null : filtercondition.trim();
    }
}