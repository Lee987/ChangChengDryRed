package com.changcheng.biz.changpda.entity;

public class UserInfoEntity {
    /**
     * code : 200
     * msg : 登陆成功
     * data : {"userInfo":{"id":"fdc085d2648e0f390164918284a30001","userName":"13554564691","fullName":"刘程","orgId":"f7f10c3e858211e8ac060cc47a800cec","currentOrgId":null,"sex":"0","password":null,"newpassword":null,"mobilePhone":"13554564691","email":"549638330@qq.com","orgName":"北京","positionId":"1","partyTimePositionId":null,"isMain":null,"positionName":"分区总","positionCode":null,"positionLevel":null,"parentPositionName":null,"parentUserName":null,"parentPositionId":null,"parentUserId":null,"enableStatus":0,"headString":null,"hasFirstTime":1,"beginDate":null,"endDate":null,"createName":"超级管理员(系统管理员)","createDate":1531449607000,"updateName":"超级管理员(系统管理员)","updateDate":1533784777000,"extChar1":null,"extChar2":null,"extChar3":null,"extChar4":null,"extChar5":null,"extChar6":null,"extChar7":null,"extChar8":null,"extChar9":null,"extChar10":null,"extNumber1":null,"extNumber2":null,"extNumber3":null,"extDate1":null,"extDate2":null,"userType":0,"searchParam":null,"createDate_begin":null,"createDate_end":null,"updateDate_begin":null,"updateDate_end":null,"custName":null,"custCode":null,"custId":null,"roleIds":null,"roleNames":null,"isDelete":null,"positionJson":null,"erpCode":null}}
     * ts : 1533784777562
     */

    private String code;
    private String msg;
    private DataBean data;
    private long ts;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public static class DataBean {
        /**
         * userInfo : {"id":"fdc085d2648e0f390164918284a30001","userName":"13554564691","fullName":"刘程","orgId":"f7f10c3e858211e8ac060cc47a800cec","currentOrgId":null,"sex":"0","password":null,"newpassword":null,"mobilePhone":"13554564691","email":"549638330@qq.com","orgName":"北京","positionId":"1","partyTimePositionId":null,"isMain":null,"positionName":"分区总","positionCode":null,"positionLevel":null,"parentPositionName":null,"parentUserName":null,"parentPositionId":null,"parentUserId":null,"enableStatus":0,"headString":null,"hasFirstTime":1,"beginDate":null,"endDate":null,"createName":"超级管理员(系统管理员)","createDate":1531449607000,"updateName":"超级管理员(系统管理员)","updateDate":1533784777000,"extChar1":null,"extChar2":null,"extChar3":null,"extChar4":null,"extChar5":null,"extChar6":null,"extChar7":null,"extChar8":null,"extChar9":null,"extChar10":null,"extNumber1":null,"extNumber2":null,"extNumber3":null,"extDate1":null,"extDate2":null,"userType":0,"searchParam":null,"createDate_begin":null,"createDate_end":null,"updateDate_begin":null,"updateDate_end":null,"custName":null,"custCode":null,"custId":null,"roleIds":null,"roleNames":null,"isDelete":null,"positionJson":null,"erpCode":null}
         */

        private UserInfoBean userInfo;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * id : fdc085d2648e0f390164918284a30001
             * userName : 13554564691
             * fullName : 刘程
             * orgId : f7f10c3e858211e8ac060cc47a800cec
             * currentOrgId : null
             * sex : 0
             * password : null
             * newpassword : null
             * mobilePhone : 13554564691
             * email : 549638330@qq.com
             * orgName : 北京
             * positionId : 1
             * partyTimePositionId : null
             * isMain : null
             * positionName : 分区总
             * positionCode : null
             * positionLevel : null
             * parentPositionName : null
             * parentUserName : null
             * parentPositionId : null
             * parentUserId : null
             * enableStatus : 0
             * headString : null
             * hasFirstTime : 1
             * beginDate : null
             * endDate : null
             * createName : 超级管理员(系统管理员)
             * createDate : 1531449607000
             * updateName : 超级管理员(系统管理员)
             * updateDate : 1533784777000
             * extChar1 : null
             * extChar2 : null
             * extChar3 : null
             * extChar4 : null
             * extChar5 : null
             * extChar6 : null
             * extChar7 : null
             * extChar8 : null
             * extChar9 : null
             * extChar10 : null
             * extNumber1 : null
             * extNumber2 : null
             * extNumber3 : null
             * extDate1 : null
             * extDate2 : null
             * userType : 0
             * searchParam : null
             * createDate_begin : null
             * createDate_end : null
             * updateDate_begin : null
             * updateDate_end : null
             * custName : null
             * custCode : null
             * custId : null
             * roleIds : null
             * roleNames : null
             * isDelete : null
             * positionJson : null
             * erpCode : null
             */

            private String id;
            private String userName;
            private String fullName;
            private String orgId;
            private Object currentOrgId;
            private String sex;
            private Object password;
            private Object newpassword;
            private String mobilePhone;
            private String email;
            private String orgName;
            private String positionId;
            private Object partyTimePositionId;
            private Object isMain;
            private String positionName;
            private Object positionCode;
            private Object positionLevel;
            private Object parentPositionName;
            private Object parentUserName;
            private Object parentPositionId;
            private Object parentUserId;
            private int enableStatus;
            private Object headString;
            private int hasFirstTime;
            private Object beginDate;
            private Object endDate;
            private String createName;
            private long createDate;
            private String updateName;
            private long updateDate;
            private Object extChar1;
            private Object extChar2;
            private Object extChar3;
            private Object extChar4;
            private Object extChar5;
            private Object extChar6;
            private Object extChar7;
            private Object extChar8;
            private Object extChar9;
            private Object extChar10;
            private Object extNumber1;
            private Object extNumber2;
            private Object extNumber3;
            private Object extDate1;
            private Object extDate2;
            private int userType;
            private Object searchParam;
            private Object createDate_begin;
            private Object createDate_end;
            private Object updateDate_begin;
            private Object updateDate_end;
            private Object custName;
            private Object custCode;
            private Object custId;
            private Object roleIds;
            private Object roleNames;
            private Object isDelete;
            private Object positionJson;
            private Object erpCode;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }

            public String getOrgId() {
                return orgId;
            }

            public void setOrgId(String orgId) {
                this.orgId = orgId;
            }

            public Object getCurrentOrgId() {
                return currentOrgId;
            }

            public void setCurrentOrgId(Object currentOrgId) {
                this.currentOrgId = currentOrgId;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public Object getNewpassword() {
                return newpassword;
            }

            public void setNewpassword(Object newpassword) {
                this.newpassword = newpassword;
            }

            public String getMobilePhone() {
                return mobilePhone;
            }

            public void setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getOrgName() {
                return orgName;
            }

            public void setOrgName(String orgName) {
                this.orgName = orgName;
            }

            public String getPositionId() {
                return positionId;
            }

            public void setPositionId(String positionId) {
                this.positionId = positionId;
            }

            public Object getPartyTimePositionId() {
                return partyTimePositionId;
            }

            public void setPartyTimePositionId(Object partyTimePositionId) {
                this.partyTimePositionId = partyTimePositionId;
            }

            public Object getIsMain() {
                return isMain;
            }

            public void setIsMain(Object isMain) {
                this.isMain = isMain;
            }

            public String getPositionName() {
                return positionName;
            }

            public void setPositionName(String positionName) {
                this.positionName = positionName;
            }

            public Object getPositionCode() {
                return positionCode;
            }

            public void setPositionCode(Object positionCode) {
                this.positionCode = positionCode;
            }

            public Object getPositionLevel() {
                return positionLevel;
            }

            public void setPositionLevel(Object positionLevel) {
                this.positionLevel = positionLevel;
            }

            public Object getParentPositionName() {
                return parentPositionName;
            }

            public void setParentPositionName(Object parentPositionName) {
                this.parentPositionName = parentPositionName;
            }

            public Object getParentUserName() {
                return parentUserName;
            }

            public void setParentUserName(Object parentUserName) {
                this.parentUserName = parentUserName;
            }

            public Object getParentPositionId() {
                return parentPositionId;
            }

            public void setParentPositionId(Object parentPositionId) {
                this.parentPositionId = parentPositionId;
            }

            public Object getParentUserId() {
                return parentUserId;
            }

            public void setParentUserId(Object parentUserId) {
                this.parentUserId = parentUserId;
            }

            public int getEnableStatus() {
                return enableStatus;
            }

            public void setEnableStatus(int enableStatus) {
                this.enableStatus = enableStatus;
            }

            public Object getHeadString() {
                return headString;
            }

            public void setHeadString(Object headString) {
                this.headString = headString;
            }

            public int getHasFirstTime() {
                return hasFirstTime;
            }

            public void setHasFirstTime(int hasFirstTime) {
                this.hasFirstTime = hasFirstTime;
            }

            public Object getBeginDate() {
                return beginDate;
            }

            public void setBeginDate(Object beginDate) {
                this.beginDate = beginDate;
            }

            public Object getEndDate() {
                return endDate;
            }

            public void setEndDate(Object endDate) {
                this.endDate = endDate;
            }

            public String getCreateName() {
                return createName;
            }

            public void setCreateName(String createName) {
                this.createName = createName;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public String getUpdateName() {
                return updateName;
            }

            public void setUpdateName(String updateName) {
                this.updateName = updateName;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public Object getExtChar1() {
                return extChar1;
            }

            public void setExtChar1(Object extChar1) {
                this.extChar1 = extChar1;
            }

            public Object getExtChar2() {
                return extChar2;
            }

            public void setExtChar2(Object extChar2) {
                this.extChar2 = extChar2;
            }

            public Object getExtChar3() {
                return extChar3;
            }

            public void setExtChar3(Object extChar3) {
                this.extChar3 = extChar3;
            }

            public Object getExtChar4() {
                return extChar4;
            }

            public void setExtChar4(Object extChar4) {
                this.extChar4 = extChar4;
            }

            public Object getExtChar5() {
                return extChar5;
            }

            public void setExtChar5(Object extChar5) {
                this.extChar5 = extChar5;
            }

            public Object getExtChar6() {
                return extChar6;
            }

            public void setExtChar6(Object extChar6) {
                this.extChar6 = extChar6;
            }

            public Object getExtChar7() {
                return extChar7;
            }

            public void setExtChar7(Object extChar7) {
                this.extChar7 = extChar7;
            }

            public Object getExtChar8() {
                return extChar8;
            }

            public void setExtChar8(Object extChar8) {
                this.extChar8 = extChar8;
            }

            public Object getExtChar9() {
                return extChar9;
            }

            public void setExtChar9(Object extChar9) {
                this.extChar9 = extChar9;
            }

            public Object getExtChar10() {
                return extChar10;
            }

            public void setExtChar10(Object extChar10) {
                this.extChar10 = extChar10;
            }

            public Object getExtNumber1() {
                return extNumber1;
            }

            public void setExtNumber1(Object extNumber1) {
                this.extNumber1 = extNumber1;
            }

            public Object getExtNumber2() {
                return extNumber2;
            }

            public void setExtNumber2(Object extNumber2) {
                this.extNumber2 = extNumber2;
            }

            public Object getExtNumber3() {
                return extNumber3;
            }

            public void setExtNumber3(Object extNumber3) {
                this.extNumber3 = extNumber3;
            }

            public Object getExtDate1() {
                return extDate1;
            }

            public void setExtDate1(Object extDate1) {
                this.extDate1 = extDate1;
            }

            public Object getExtDate2() {
                return extDate2;
            }

            public void setExtDate2(Object extDate2) {
                this.extDate2 = extDate2;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public Object getSearchParam() {
                return searchParam;
            }

            public void setSearchParam(Object searchParam) {
                this.searchParam = searchParam;
            }

            public Object getCreateDate_begin() {
                return createDate_begin;
            }

            public void setCreateDate_begin(Object createDate_begin) {
                this.createDate_begin = createDate_begin;
            }

            public Object getCreateDate_end() {
                return createDate_end;
            }

            public void setCreateDate_end(Object createDate_end) {
                this.createDate_end = createDate_end;
            }

            public Object getUpdateDate_begin() {
                return updateDate_begin;
            }

            public void setUpdateDate_begin(Object updateDate_begin) {
                this.updateDate_begin = updateDate_begin;
            }

            public Object getUpdateDate_end() {
                return updateDate_end;
            }

            public void setUpdateDate_end(Object updateDate_end) {
                this.updateDate_end = updateDate_end;
            }

            public Object getCustName() {
                return custName;
            }

            public void setCustName(Object custName) {
                this.custName = custName;
            }

            public Object getCustCode() {
                return custCode;
            }

            public void setCustCode(Object custCode) {
                this.custCode = custCode;
            }

            public Object getCustId() {
                return custId;
            }

            public void setCustId(Object custId) {
                this.custId = custId;
            }

            public Object getRoleIds() {
                return roleIds;
            }

            public void setRoleIds(Object roleIds) {
                this.roleIds = roleIds;
            }

            public Object getRoleNames() {
                return roleNames;
            }

            public void setRoleNames(Object roleNames) {
                this.roleNames = roleNames;
            }

            public Object getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(Object isDelete) {
                this.isDelete = isDelete;
            }

            public Object getPositionJson() {
                return positionJson;
            }

            public void setPositionJson(Object positionJson) {
                this.positionJson = positionJson;
            }

            public Object getErpCode() {
                return erpCode;
            }

            public void setErpCode(Object erpCode) {
                this.erpCode = erpCode;
            }
        }
    }
}
