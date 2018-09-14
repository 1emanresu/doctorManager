package cn.yunji.doctormanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PregnancyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PregnancyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPcidIsNull() {
            addCriterion("PCId is null");
            return (Criteria) this;
        }

        public Criteria andPcidIsNotNull() {
            addCriterion("PCId is not null");
            return (Criteria) this;
        }

        public Criteria andPcidEqualTo(Integer value) {
            addCriterion("PCId =", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidNotEqualTo(Integer value) {
            addCriterion("PCId <>", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidGreaterThan(Integer value) {
            addCriterion("PCId >", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PCId >=", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidLessThan(Integer value) {
            addCriterion("PCId <", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidLessThanOrEqualTo(Integer value) {
            addCriterion("PCId <=", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidIn(List<Integer> values) {
            addCriterion("PCId in", values, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidNotIn(List<Integer> values) {
            addCriterion("PCId not in", values, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidBetween(Integer value1, Integer value2) {
            addCriterion("PCId between", value1, value2, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidNotBetween(Integer value1, Integer value2) {
            addCriterion("PCId not between", value1, value2, "pcid");
            return (Criteria) this;
        }

        public Criteria andMnameIsNull() {
            addCriterion("mName is null");
            return (Criteria) this;
        }

        public Criteria andMnameIsNotNull() {
            addCriterion("mName is not null");
            return (Criteria) this;
        }

        public Criteria andMnameEqualTo(String value) {
            addCriterion("mName =", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotEqualTo(String value) {
            addCriterion("mName <>", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThan(String value) {
            addCriterion("mName >", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThanOrEqualTo(String value) {
            addCriterion("mName >=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThan(String value) {
            addCriterion("mName <", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThanOrEqualTo(String value) {
            addCriterion("mName <=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLike(String value) {
            addCriterion("mName like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotLike(String value) {
            addCriterion("mName not like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameIn(List<String> values) {
            addCriterion("mName in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotIn(List<String> values) {
            addCriterion("mName not in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameBetween(String value1, String value2) {
            addCriterion("mName between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotBetween(String value1, String value2) {
            addCriterion("mName not between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMageIsNull() {
            addCriterion("mAge is null");
            return (Criteria) this;
        }

        public Criteria andMageIsNotNull() {
            addCriterion("mAge is not null");
            return (Criteria) this;
        }

        public Criteria andMageEqualTo(Integer value) {
            addCriterion("mAge =", value, "mage");
            return (Criteria) this;
        }

        public Criteria andMageNotEqualTo(Integer value) {
            addCriterion("mAge <>", value, "mage");
            return (Criteria) this;
        }

        public Criteria andMageGreaterThan(Integer value) {
            addCriterion("mAge >", value, "mage");
            return (Criteria) this;
        }

        public Criteria andMageGreaterThanOrEqualTo(Integer value) {
            addCriterion("mAge >=", value, "mage");
            return (Criteria) this;
        }

        public Criteria andMageLessThan(Integer value) {
            addCriterion("mAge <", value, "mage");
            return (Criteria) this;
        }

        public Criteria andMageLessThanOrEqualTo(Integer value) {
            addCriterion("mAge <=", value, "mage");
            return (Criteria) this;
        }

        public Criteria andMageIn(List<Integer> values) {
            addCriterion("mAge in", values, "mage");
            return (Criteria) this;
        }

        public Criteria andMageNotIn(List<Integer> values) {
            addCriterion("mAge not in", values, "mage");
            return (Criteria) this;
        }

        public Criteria andMageBetween(Integer value1, Integer value2) {
            addCriterion("mAge between", value1, value2, "mage");
            return (Criteria) this;
        }

        public Criteria andMageNotBetween(Integer value1, Integer value2) {
            addCriterion("mAge not between", value1, value2, "mage");
            return (Criteria) this;
        }

        public Criteria andPcdateIsNull() {
            addCriterion("PCDate is null");
            return (Criteria) this;
        }

        public Criteria andPcdateIsNotNull() {
            addCriterion("PCDate is not null");
            return (Criteria) this;
        }

        public Criteria andPcdateEqualTo(Date value) {
            addCriterionForJDBCDate("PCDate =", value, "pcdate");
            return (Criteria) this;
        }

        public Criteria andPcdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PCDate <>", value, "pcdate");
            return (Criteria) this;
        }

        public Criteria andPcdateGreaterThan(Date value) {
            addCriterionForJDBCDate("PCDate >", value, "pcdate");
            return (Criteria) this;
        }

        public Criteria andPcdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PCDate >=", value, "pcdate");
            return (Criteria) this;
        }

        public Criteria andPcdateLessThan(Date value) {
            addCriterionForJDBCDate("PCDate <", value, "pcdate");
            return (Criteria) this;
        }

        public Criteria andPcdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PCDate <=", value, "pcdate");
            return (Criteria) this;
        }

        public Criteria andPcdateIn(List<Date> values) {
            addCriterionForJDBCDate("PCDate in", values, "pcdate");
            return (Criteria) this;
        }

        public Criteria andPcdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PCDate not in", values, "pcdate");
            return (Criteria) this;
        }

        public Criteria andPcdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PCDate between", value1, value2, "pcdate");
            return (Criteria) this;
        }

        public Criteria andPcdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PCDate not between", value1, value2, "pcdate");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andSibshipIsNull() {
            addCriterion("sibship is null");
            return (Criteria) this;
        }

        public Criteria andSibshipIsNotNull() {
            addCriterion("sibship is not null");
            return (Criteria) this;
        }

        public Criteria andSibshipEqualTo(Integer value) {
            addCriterion("sibship =", value, "sibship");
            return (Criteria) this;
        }

        public Criteria andSibshipNotEqualTo(Integer value) {
            addCriterion("sibship <>", value, "sibship");
            return (Criteria) this;
        }

        public Criteria andSibshipGreaterThan(Integer value) {
            addCriterion("sibship >", value, "sibship");
            return (Criteria) this;
        }

        public Criteria andSibshipGreaterThanOrEqualTo(Integer value) {
            addCriterion("sibship >=", value, "sibship");
            return (Criteria) this;
        }

        public Criteria andSibshipLessThan(Integer value) {
            addCriterion("sibship <", value, "sibship");
            return (Criteria) this;
        }

        public Criteria andSibshipLessThanOrEqualTo(Integer value) {
            addCriterion("sibship <=", value, "sibship");
            return (Criteria) this;
        }

        public Criteria andSibshipIn(List<Integer> values) {
            addCriterion("sibship in", values, "sibship");
            return (Criteria) this;
        }

        public Criteria andSibshipNotIn(List<Integer> values) {
            addCriterion("sibship not in", values, "sibship");
            return (Criteria) this;
        }

        public Criteria andSibshipBetween(Integer value1, Integer value2) {
            addCriterion("sibship between", value1, value2, "sibship");
            return (Criteria) this;
        }

        public Criteria andSibshipNotBetween(Integer value1, Integer value2) {
            addCriterion("sibship not between", value1, value2, "sibship");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleIsNull() {
            addCriterion("menstrualCycle is null");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleIsNotNull() {
            addCriterion("menstrualCycle is not null");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleEqualTo(Integer value) {
            addCriterion("menstrualCycle =", value, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleNotEqualTo(Integer value) {
            addCriterion("menstrualCycle <>", value, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleGreaterThan(Integer value) {
            addCriterion("menstrualCycle >", value, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("menstrualCycle >=", value, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleLessThan(Integer value) {
            addCriterion("menstrualCycle <", value, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleLessThanOrEqualTo(Integer value) {
            addCriterion("menstrualCycle <=", value, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleIn(List<Integer> values) {
            addCriterion("menstrualCycle in", values, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleNotIn(List<Integer> values) {
            addCriterion("menstrualCycle not in", values, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleBetween(Integer value1, Integer value2) {
            addCriterion("menstrualCycle between", value1, value2, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andMenstrualcycleNotBetween(Integer value1, Integer value2) {
            addCriterion("menstrualCycle not between", value1, value2, "menstrualcycle");
            return (Criteria) this;
        }

        public Criteria andOneageIsNull() {
            addCriterion("oneAge is null");
            return (Criteria) this;
        }

        public Criteria andOneageIsNotNull() {
            addCriterion("oneAge is not null");
            return (Criteria) this;
        }

        public Criteria andOneageEqualTo(Integer value) {
            addCriterion("oneAge =", value, "oneage");
            return (Criteria) this;
        }

        public Criteria andOneageNotEqualTo(Integer value) {
            addCriterion("oneAge <>", value, "oneage");
            return (Criteria) this;
        }

        public Criteria andOneageGreaterThan(Integer value) {
            addCriterion("oneAge >", value, "oneage");
            return (Criteria) this;
        }

        public Criteria andOneageGreaterThanOrEqualTo(Integer value) {
            addCriterion("oneAge >=", value, "oneage");
            return (Criteria) this;
        }

        public Criteria andOneageLessThan(Integer value) {
            addCriterion("oneAge <", value, "oneage");
            return (Criteria) this;
        }

        public Criteria andOneageLessThanOrEqualTo(Integer value) {
            addCriterion("oneAge <=", value, "oneage");
            return (Criteria) this;
        }

        public Criteria andOneageIn(List<Integer> values) {
            addCriterion("oneAge in", values, "oneage");
            return (Criteria) this;
        }

        public Criteria andOneageNotIn(List<Integer> values) {
            addCriterion("oneAge not in", values, "oneage");
            return (Criteria) this;
        }

        public Criteria andOneageBetween(Integer value1, Integer value2) {
            addCriterion("oneAge between", value1, value2, "oneage");
            return (Criteria) this;
        }

        public Criteria andOneageNotBetween(Integer value1, Integer value2) {
            addCriterion("oneAge not between", value1, value2, "oneage");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryIsNull() {
            addCriterion("familyHistory is null");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryIsNotNull() {
            addCriterion("familyHistory is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryEqualTo(Integer value) {
            addCriterion("familyHistory =", value, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryNotEqualTo(Integer value) {
            addCriterion("familyHistory <>", value, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryGreaterThan(Integer value) {
            addCriterion("familyHistory >", value, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("familyHistory >=", value, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryLessThan(Integer value) {
            addCriterion("familyHistory <", value, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryLessThanOrEqualTo(Integer value) {
            addCriterion("familyHistory <=", value, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryIn(List<Integer> values) {
            addCriterion("familyHistory in", values, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryNotIn(List<Integer> values) {
            addCriterion("familyHistory not in", values, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryBetween(Integer value1, Integer value2) {
            addCriterion("familyHistory between", value1, value2, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andFamilyhistoryNotBetween(Integer value1, Integer value2) {
            addCriterion("familyHistory not between", value1, value2, "familyhistory");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageIsNull() {
            addCriterion("recentMarriage is null");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageIsNotNull() {
            addCriterion("recentMarriage is not null");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageEqualTo(Integer value) {
            addCriterion("recentMarriage =", value, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageNotEqualTo(Integer value) {
            addCriterion("recentMarriage <>", value, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageGreaterThan(Integer value) {
            addCriterion("recentMarriage >", value, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageGreaterThanOrEqualTo(Integer value) {
            addCriterion("recentMarriage >=", value, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageLessThan(Integer value) {
            addCriterion("recentMarriage <", value, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageLessThanOrEqualTo(Integer value) {
            addCriterion("recentMarriage <=", value, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageIn(List<Integer> values) {
            addCriterion("recentMarriage in", values, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageNotIn(List<Integer> values) {
            addCriterion("recentMarriage not in", values, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageBetween(Integer value1, Integer value2) {
            addCriterion("recentMarriage between", value1, value2, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andRecentmarriageNotBetween(Integer value1, Integer value2) {
            addCriterion("recentMarriage not between", value1, value2, "recentmarriage");
            return (Criteria) this;
        }

        public Criteria andMentalstateIsNull() {
            addCriterion("mentalstate is null");
            return (Criteria) this;
        }

        public Criteria andMentalstateIsNotNull() {
            addCriterion("mentalstate is not null");
            return (Criteria) this;
        }

        public Criteria andMentalstateEqualTo(Integer value) {
            addCriterion("mentalstate =", value, "mentalstate");
            return (Criteria) this;
        }

        public Criteria andMentalstateNotEqualTo(Integer value) {
            addCriterion("mentalstate <>", value, "mentalstate");
            return (Criteria) this;
        }

        public Criteria andMentalstateGreaterThan(Integer value) {
            addCriterion("mentalstate >", value, "mentalstate");
            return (Criteria) this;
        }

        public Criteria andMentalstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("mentalstate >=", value, "mentalstate");
            return (Criteria) this;
        }

        public Criteria andMentalstateLessThan(Integer value) {
            addCriterion("mentalstate <", value, "mentalstate");
            return (Criteria) this;
        }

        public Criteria andMentalstateLessThanOrEqualTo(Integer value) {
            addCriterion("mentalstate <=", value, "mentalstate");
            return (Criteria) this;
        }

        public Criteria andMentalstateIn(List<Integer> values) {
            addCriterion("mentalstate in", values, "mentalstate");
            return (Criteria) this;
        }

        public Criteria andMentalstateNotIn(List<Integer> values) {
            addCriterion("mentalstate not in", values, "mentalstate");
            return (Criteria) this;
        }

        public Criteria andMentalstateBetween(Integer value1, Integer value2) {
            addCriterion("mentalstate between", value1, value2, "mentalstate");
            return (Criteria) this;
        }

        public Criteria andMentalstateNotBetween(Integer value1, Integer value2) {
            addCriterion("mentalstate not between", value1, value2, "mentalstate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}