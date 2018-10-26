package com.changcheng.biz.changpda.entity;

import java.util.List;

public class LossEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : [{"id":"40288a6965406d920165406f6d490005","reportLossCode":"BS00000137","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"0","remarks":"","status":3,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-16 09:52:49.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null},{"id":"fdc085d2654069660165406b81ec000b","reportLossCode":"BS00000136","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"0","remarks":"","status":3,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-16 09:48:32.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null},{"id":"40288a69653ccda401653ce5cc620039","reportLossCode":"BS00000131","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"0","remarks":"","status":1,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-15 17:23:38.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null},{"id":"40288a69653ccda401653cdb8eb80030","reportLossCode":"BS00000128","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"1","remarks":null,"status":1,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-15 17:12:27.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null},{"id":"40288a69653ccda401653cda8ce4002b","reportLossCode":"BS00000127","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"1","remarks":null,"status":1,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-15 17:11:21.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null},{"id":"40288a69653ccda401653cda393d0026","reportLossCode":"BS00000126","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"1","remarks":null,"status":1,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-15 17:10:59.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null},{"id":"40288a69653ccda401653cd9bb5c0021","reportLossCode":"BS00000125","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"1","remarks":null,"status":1,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-15 17:10:27.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null},{"id":"40288a69653ccda401653cd349d30016","reportLossCode":"BS00000123","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"0","remarks":"","status":1,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-15 17:03:38.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null},{"id":"40288a69653ccda401653ccfc50c0005","reportLossCode":"BS00000122","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"0","remarks":"","status":0,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-15 16:59:49.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null},{"id":"40288a69653cb18701653cb3b2d80000","reportLossCode":"BS00000121","reportLossPartyCode":"10002149","reportLossPartyName":"北京东城糖业烟酒有限公司","reportLossType":"0","remarks":"","status":0,"reportLossOperationName":"李四","reportLossOperatiionTime":"2018-08-15 16:28:54.0","statusText":null,"reportLossTypeText":null,"reportLossPartyId":"a992c35f8f3d11e8ac060cc47a800cec","customerId":null,"userId":null}]
     * ts : 1534388661413
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
         * id : 40288a6965406d920165406f6d490005
         * reportLossCode : BS00000137
         * reportLossPartyCode : 10002149
         * reportLossPartyName : 北京东城糖业烟酒有限公司
         * reportLossType : 0
         * remarks :
         * status : 3
         * reportLossOperationName : 李四
         * reportLossOperatiionTime : 2018-08-16 09:52:49.0
         * statusText : null
         * reportLossTypeText : null
         * reportLossPartyId : a992c35f8f3d11e8ac060cc47a800cec
         * customerId : null
         * userId : null
         */

        private String id;
        private String reportLossCode;
        private String reportLossPartyCode;
        private String reportLossPartyName;
        private String reportLossType;
        private String remarks;
        private int status;
        private String reportLossOperationName;
        private String reportLossOperatiionTime;
        private Object statusText;
        private Object reportLossTypeText;
        private String reportLossPartyId;
        private Object customerId;
        private Object userId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getReportLossCode() {
            return reportLossCode;
        }

        public void setReportLossCode(String reportLossCode) {
            this.reportLossCode = reportLossCode;
        }

        public String getReportLossPartyCode() {
            return reportLossPartyCode;
        }

        public void setReportLossPartyCode(String reportLossPartyCode) {
            this.reportLossPartyCode = reportLossPartyCode;
        }

        public String getReportLossPartyName() {
            return reportLossPartyName;
        }

        public void setReportLossPartyName(String reportLossPartyName) {
            this.reportLossPartyName = reportLossPartyName;
        }

        public String getReportLossType() {
            return reportLossType;
        }

        public void setReportLossType(String reportLossType) {
            this.reportLossType = reportLossType;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getReportLossOperationName() {
            return reportLossOperationName;
        }

        public void setReportLossOperationName(String reportLossOperationName) {
            this.reportLossOperationName = reportLossOperationName;
        }

        public String getReportLossOperatiionTime() {
            return reportLossOperatiionTime;
        }

        public void setReportLossOperatiionTime(String reportLossOperatiionTime) {
            this.reportLossOperatiionTime = reportLossOperatiionTime;
        }

        public Object getStatusText() {
            return statusText;
        }

        public void setStatusText(Object statusText) {
            this.statusText = statusText;
        }

        public Object getReportLossTypeText() {
            return reportLossTypeText;
        }

        public void setReportLossTypeText(Object reportLossTypeText) {
            this.reportLossTypeText = reportLossTypeText;
        }

        public String getReportLossPartyId() {
            return reportLossPartyId;
        }

        public void setReportLossPartyId(String reportLossPartyId) {
            this.reportLossPartyId = reportLossPartyId;
        }

        public Object getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Object customerId) {
            this.customerId = customerId;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }
    }
}
