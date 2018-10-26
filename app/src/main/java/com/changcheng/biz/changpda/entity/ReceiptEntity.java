package com.changcheng.biz.changpda.entity;

import java.util.List;

public class ReceiptEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : [{"id":"fdc085d26532791101653292d3380009","sapOrderCode":null,"deliveryCode":"83677153","receivingPartyId":"a992c35f8f3d11e8ac060cc47a800cec","receivingPartyCode":"10019767","receivingPartyName":"西藏九鼎商贸有限公司","receivingPartyTel":null,"leaveLibraryCode":"10019767","leaveLibraryName":"西藏九鼎商贸有限公司","leaveLibraryTel":"13554564691","status":1,"statusName":"已签收","singnDate":"2018-08-13 09:42:27","singnName":"蒲鹏","createDate":"2018-08-13 09:16:48","startTime":null,"endTime":null,"createName":"超级管理员(特务专员)","updateDate":"2018-08-13 09:42:27","updateName":"蒲鹏","orgIds":null,"orgId":null},{"id":"fdc085d26532791101653292d33a000b","sapOrderCode":null,"deliveryCode":"83677154","receivingPartyId":"a992c35f8f3d11e8ac060cc47a800cec","receivingPartyCode":"10019767","receivingPartyName":"西藏九鼎商贸有限公司","receivingPartyTel":null,"leaveLibraryCode":"10019767","leaveLibraryName":"西藏九鼎商贸有限公司","leaveLibraryTel":"13554564691","status":1,"statusName":"已签收","singnDate":"2018-08-13 09:42:34","singnName":"蒲鹏","createDate":"2018-08-13 09:16:48","startTime":null,"endTime":null,"createName":"超级管理员(特务专员)","updateDate":"2018-08-13 09:42:34","updateName":"蒲鹏","orgIds":null,"orgId":null}]
     * ts : 1534216101826
     */

    private String code;
    private String msg;
    private long ts;
    private List<DataBean> data;

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

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : fdc085d26532791101653292d3380009
         * sapOrderCode : null
         * deliveryCode : 83677153
         * receivingPartyId : a992c35f8f3d11e8ac060cc47a800cec
         * receivingPartyCode : 10019767
         * receivingPartyName : 西藏九鼎商贸有限公司
         * receivingPartyTel : null
         * leaveLibraryCode : 10019767
         * leaveLibraryName : 西藏九鼎商贸有限公司
         * leaveLibraryTel : 13554564691
         * status : 1
         * statusName : 已签收
         * singnDate : 2018-08-13 09:42:27
         * singnName : 蒲鹏
         * createDate : 2018-08-13 09:16:48
         * startTime : null
         * endTime : null
         * createName : 超级管理员(特务专员)
         * updateDate : 2018-08-13 09:42:27
         * updateName : 蒲鹏
         * orgIds : null
         * orgId : null
         */

        private String id;
        private Object sapOrderCode;
        private String deliveryCode;
        private String receivingPartyId;
        private String receivingPartyCode;
        private String receivingPartyName;
        private Object receivingPartyTel;
        private String leaveLibraryCode;
        private String leaveLibraryName;
        private String leaveLibraryTel;
        private int status;
        private String statusName;
        private String singnDate;
        private String singnName;
        private String createDate;
        private Object startTime;
        private Object endTime;
        private String createName;
        private String updateDate;
        private String updateName;
        private Object orgIds;
        private Object orgId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getSapOrderCode() {
            return sapOrderCode;
        }

        public void setSapOrderCode(Object sapOrderCode) {
            this.sapOrderCode = sapOrderCode;
        }

        public String getDeliveryCode() {
            return deliveryCode;
        }

        public void setDeliveryCode(String deliveryCode) {
            this.deliveryCode = deliveryCode;
        }

        public String getReceivingPartyId() {
            return receivingPartyId;
        }

        public void setReceivingPartyId(String receivingPartyId) {
            this.receivingPartyId = receivingPartyId;
        }

        public String getReceivingPartyCode() {
            return receivingPartyCode;
        }

        public void setReceivingPartyCode(String receivingPartyCode) {
            this.receivingPartyCode = receivingPartyCode;
        }

        public String getReceivingPartyName() {
            return receivingPartyName;
        }

        public void setReceivingPartyName(String receivingPartyName) {
            this.receivingPartyName = receivingPartyName;
        }

        public Object getReceivingPartyTel() {
            return receivingPartyTel;
        }

        public void setReceivingPartyTel(Object receivingPartyTel) {
            this.receivingPartyTel = receivingPartyTel;
        }

        public String getLeaveLibraryCode() {
            return leaveLibraryCode;
        }

        public void setLeaveLibraryCode(String leaveLibraryCode) {
            this.leaveLibraryCode = leaveLibraryCode;
        }

        public String getLeaveLibraryName() {
            return leaveLibraryName;
        }

        public void setLeaveLibraryName(String leaveLibraryName) {
            this.leaveLibraryName = leaveLibraryName;
        }

        public String getLeaveLibraryTel() {
            return leaveLibraryTel;
        }

        public void setLeaveLibraryTel(String leaveLibraryTel) {
            this.leaveLibraryTel = leaveLibraryTel;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public String getSingnDate() {
            return singnDate;
        }

        public void setSingnDate(String singnDate) {
            this.singnDate = singnDate;
        }

        public String getSingnName() {
            return singnName;
        }

        public void setSingnName(String singnName) {
            this.singnName = singnName;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(Object startTime) {
            this.startTime = startTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getUpdateName() {
            return updateName;
        }

        public void setUpdateName(String updateName) {
            this.updateName = updateName;
        }

        public Object getOrgIds() {
            return orgIds;
        }

        public void setOrgIds(Object orgIds) {
            this.orgIds = orgIds;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }
    }
}
