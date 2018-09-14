package cn.yunji.doctormanager.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FamilyMember {
    private Integer fmid;

    private Integer relationid;

    private String mid;

    private String name;

    private Integer age;

    private String profession;

    private String nation;

    private String identitycard;

    private String workunit; 

    private String phone;

    private Integer bloodtype;

    private String hpersonalhistory;

    private Integer rh;
    
    private GravidaInfo gravidaInfo;
    
    private Integer idcard_type;
    
    private String work;
  
    private String nationality;
    
    private String education;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthYears;
    
    private String other;
    
    private String relations;
    
    private Integer count;
    
    /*@Author hongwx增加关系表的关联*/
    private Relation relation;
    
    
    public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}
    
    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getIdcard_type() {
		return idcard_type;
	}

	public void setIdcard_type(Integer idcard_type) {
		this.idcard_type = idcard_type;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getBirthYears() {
		return birthYears;
	}

	public void setBirthYears(Date birthYears) {
		this.birthYears = birthYears;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getRelations() {
		return relations;
	}

	public void setRelations(String relations) {
		this.relations = relations;
	}

	public Integer getFmid() {
        return fmid;
    }

    public void setFmid(Integer fmid) {
        this.fmid = fmid;
    }

    public Integer getRelationid() {
        return relationid;
    }

    public void setRelationid(Integer relationid) {
        this.relationid = relationid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard == null ? null : identitycard.trim();
    }

    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit == null ? null : workunit.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(Integer bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getHpersonalhistory() {
        return hpersonalhistory;
    }

    public void setHpersonalhistory(String hpersonalhistory) {
        this.hpersonalhistory = hpersonalhistory == null ? null : hpersonalhistory.trim();
    }

    public Integer getRh() {
        return rh;
    }

    public void setRh(Integer rh) {
        this.rh = rh;
    }

	public GravidaInfo getGravidaInfo() {
		return gravidaInfo;
	}

	public void setGravidaInfo(GravidaInfo gravidaInfo) {
		this.gravidaInfo = gravidaInfo;
	}

	@Override
	public String toString() {
		return "FamilyMember [fmid=" + fmid + ", relationid=" + relationid + ", mid=" + mid + ", name=" + name
				+ ", age=" + age + ", profession=" + profession + ", nation=" + nation + ", identitycard="
				+ identitycard + ", workunit=" + workunit + ", phone=" + phone + ", bloodtype=" + bloodtype
				+ ", hpersonalhistory=" + hpersonalhistory + ", rh=" + rh + ", gravidaInfo=" + gravidaInfo
				+ ", idcard_type=" + idcard_type + ", work=" + work + ", nationality=" + nationality + ", education="
				+ education + ", birthYears=" + birthYears + ", other=" + other + ", relations=" + relations + "]";
	}


    
    
}