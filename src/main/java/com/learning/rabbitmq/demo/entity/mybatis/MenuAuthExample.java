package com.learning.rabbitmq.demo.entity.mybatis;

import java.util.ArrayList;
import java.util.List;

public class MenuAuthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuAuthExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAuthNameIsNull() {
            addCriterion("auth_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthNameIsNotNull() {
            addCriterion("auth_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthNameEqualTo(String value) {
            addCriterion("auth_name =", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotEqualTo(String value) {
            addCriterion("auth_name <>", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThan(String value) {
            addCriterion("auth_name >", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThanOrEqualTo(String value) {
            addCriterion("auth_name >=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThan(String value) {
            addCriterion("auth_name <", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThanOrEqualTo(String value) {
            addCriterion("auth_name <=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLike(String value) {
            addCriterion("auth_name like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotLike(String value) {
            addCriterion("auth_name not like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameIn(List<String> values) {
            addCriterion("auth_name in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotIn(List<String> values) {
            addCriterion("auth_name not in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameBetween(String value1, String value2) {
            addCriterion("auth_name between", value1, value2, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotBetween(String value1, String value2) {
            addCriterion("auth_name not between", value1, value2, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthUrlIsNull() {
            addCriterion("auth_url is null");
            return (Criteria) this;
        }

        public Criteria andAuthUrlIsNotNull() {
            addCriterion("auth_url is not null");
            return (Criteria) this;
        }

        public Criteria andAuthUrlEqualTo(String value) {
            addCriterion("auth_url =", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlNotEqualTo(String value) {
            addCriterion("auth_url <>", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlGreaterThan(String value) {
            addCriterion("auth_url >", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlGreaterThanOrEqualTo(String value) {
            addCriterion("auth_url >=", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlLessThan(String value) {
            addCriterion("auth_url <", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlLessThanOrEqualTo(String value) {
            addCriterion("auth_url <=", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlLike(String value) {
            addCriterion("auth_url like", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlNotLike(String value) {
            addCriterion("auth_url not like", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlIn(List<String> values) {
            addCriterion("auth_url in", values, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlNotIn(List<String> values) {
            addCriterion("auth_url not in", values, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlBetween(String value1, String value2) {
            addCriterion("auth_url between", value1, value2, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlNotBetween(String value1, String value2) {
            addCriterion("auth_url not between", value1, value2, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionIsNull() {
            addCriterion("auth_permission is null");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionIsNotNull() {
            addCriterion("auth_permission is not null");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionEqualTo(String value) {
            addCriterion("auth_permission =", value, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionNotEqualTo(String value) {
            addCriterion("auth_permission <>", value, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionGreaterThan(String value) {
            addCriterion("auth_permission >", value, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("auth_permission >=", value, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionLessThan(String value) {
            addCriterion("auth_permission <", value, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionLessThanOrEqualTo(String value) {
            addCriterion("auth_permission <=", value, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionLike(String value) {
            addCriterion("auth_permission like", value, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionNotLike(String value) {
            addCriterion("auth_permission not like", value, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionIn(List<String> values) {
            addCriterion("auth_permission in", values, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionNotIn(List<String> values) {
            addCriterion("auth_permission not in", values, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionBetween(String value1, String value2) {
            addCriterion("auth_permission between", value1, value2, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthPermissionNotBetween(String value1, String value2) {
            addCriterion("auth_permission not between", value1, value2, "authPermission");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNull() {
            addCriterion("auth_type is null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNotNull() {
            addCriterion("auth_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeEqualTo(String value) {
            addCriterion("auth_type =", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotEqualTo(String value) {
            addCriterion("auth_type <>", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThan(String value) {
            addCriterion("auth_type >", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThanOrEqualTo(String value) {
            addCriterion("auth_type >=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThan(String value) {
            addCriterion("auth_type <", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThanOrEqualTo(String value) {
            addCriterion("auth_type <=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLike(String value) {
            addCriterion("auth_type like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotLike(String value) {
            addCriterion("auth_type not like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIn(List<String> values) {
            addCriterion("auth_type in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotIn(List<String> values) {
            addCriterion("auth_type not in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeBetween(String value1, String value2) {
            addCriterion("auth_type between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotBetween(String value1, String value2) {
            addCriterion("auth_type not between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthStatusIsNull() {
            addCriterion("auth_status is null");
            return (Criteria) this;
        }

        public Criteria andAuthStatusIsNotNull() {
            addCriterion("auth_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuthStatusEqualTo(String value) {
            addCriterion("auth_status =", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotEqualTo(String value) {
            addCriterion("auth_status <>", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusGreaterThan(String value) {
            addCriterion("auth_status >", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusGreaterThanOrEqualTo(String value) {
            addCriterion("auth_status >=", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusLessThan(String value) {
            addCriterion("auth_status <", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusLessThanOrEqualTo(String value) {
            addCriterion("auth_status <=", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusLike(String value) {
            addCriterion("auth_status like", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotLike(String value) {
            addCriterion("auth_status not like", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusIn(List<String> values) {
            addCriterion("auth_status in", values, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotIn(List<String> values) {
            addCriterion("auth_status not in", values, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusBetween(String value1, String value2) {
            addCriterion("auth_status between", value1, value2, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotBetween(String value1, String value2) {
            addCriterion("auth_status not between", value1, value2, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionIsNull() {
            addCriterion("auth_descrtion is null");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionIsNotNull() {
            addCriterion("auth_descrtion is not null");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionEqualTo(String value) {
            addCriterion("auth_descrtion =", value, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionNotEqualTo(String value) {
            addCriterion("auth_descrtion <>", value, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionGreaterThan(String value) {
            addCriterion("auth_descrtion >", value, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionGreaterThanOrEqualTo(String value) {
            addCriterion("auth_descrtion >=", value, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionLessThan(String value) {
            addCriterion("auth_descrtion <", value, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionLessThanOrEqualTo(String value) {
            addCriterion("auth_descrtion <=", value, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionLike(String value) {
            addCriterion("auth_descrtion like", value, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionNotLike(String value) {
            addCriterion("auth_descrtion not like", value, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionIn(List<String> values) {
            addCriterion("auth_descrtion in", values, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionNotIn(List<String> values) {
            addCriterion("auth_descrtion not in", values, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionBetween(String value1, String value2) {
            addCriterion("auth_descrtion between", value1, value2, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthDescrtionNotBetween(String value1, String value2) {
            addCriterion("auth_descrtion not between", value1, value2, "authDescrtion");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdIsNull() {
            addCriterion("auth_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdIsNotNull() {
            addCriterion("auth_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdEqualTo(String value) {
            addCriterion("auth_parent_id =", value, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdNotEqualTo(String value) {
            addCriterion("auth_parent_id <>", value, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdGreaterThan(String value) {
            addCriterion("auth_parent_id >", value, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("auth_parent_id >=", value, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdLessThan(String value) {
            addCriterion("auth_parent_id <", value, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdLessThanOrEqualTo(String value) {
            addCriterion("auth_parent_id <=", value, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdLike(String value) {
            addCriterion("auth_parent_id like", value, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdNotLike(String value) {
            addCriterion("auth_parent_id not like", value, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdIn(List<String> values) {
            addCriterion("auth_parent_id in", values, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdNotIn(List<String> values) {
            addCriterion("auth_parent_id not in", values, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdBetween(String value1, String value2) {
            addCriterion("auth_parent_id between", value1, value2, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthParentIdNotBetween(String value1, String value2) {
            addCriterion("auth_parent_id not between", value1, value2, "authParentId");
            return (Criteria) this;
        }

        public Criteria andAuthOrderIsNull() {
            addCriterion("auth_order is null");
            return (Criteria) this;
        }

        public Criteria andAuthOrderIsNotNull() {
            addCriterion("auth_order is not null");
            return (Criteria) this;
        }

        public Criteria andAuthOrderEqualTo(Integer value) {
            addCriterion("auth_order =", value, "authOrder");
            return (Criteria) this;
        }

        public Criteria andAuthOrderNotEqualTo(Integer value) {
            addCriterion("auth_order <>", value, "authOrder");
            return (Criteria) this;
        }

        public Criteria andAuthOrderGreaterThan(Integer value) {
            addCriterion("auth_order >", value, "authOrder");
            return (Criteria) this;
        }

        public Criteria andAuthOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("auth_order >=", value, "authOrder");
            return (Criteria) this;
        }

        public Criteria andAuthOrderLessThan(Integer value) {
            addCriterion("auth_order <", value, "authOrder");
            return (Criteria) this;
        }

        public Criteria andAuthOrderLessThanOrEqualTo(Integer value) {
            addCriterion("auth_order <=", value, "authOrder");
            return (Criteria) this;
        }

        public Criteria andAuthOrderIn(List<Integer> values) {
            addCriterion("auth_order in", values, "authOrder");
            return (Criteria) this;
        }

        public Criteria andAuthOrderNotIn(List<Integer> values) {
            addCriterion("auth_order not in", values, "authOrder");
            return (Criteria) this;
        }

        public Criteria andAuthOrderBetween(Integer value1, Integer value2) {
            addCriterion("auth_order between", value1, value2, "authOrder");
            return (Criteria) this;
        }

        public Criteria andAuthOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("auth_order not between", value1, value2, "authOrder");
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