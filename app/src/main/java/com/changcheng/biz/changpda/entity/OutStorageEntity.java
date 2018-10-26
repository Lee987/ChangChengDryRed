package com.changcheng.biz.changpda.entity;

import java.util.List;

public class OutStorageEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"total":"1","pages":"1","rows":[{"id":"40288ac764ef59f20164ef5f6cbb0006","outTreasuryCode":"CK00000133","receivingPartyCode":"MD00000053","receivingPartyId":"1388","receivingPartyName":"经销商测试终端","shipperId":"a993e7628f3d11e8ac060cc47a800cec","shipperCode":"10003480","shipperName":"金华市开发区金谷粮油有限公司","shipperPhone":"135545646911","status":1,"outTime":null,"operationName":"刘程","customerId":null,"createDate":1533024366000,"createName":"刘程","updateDate":1533024367000,"updateName":"刘程","cusIds":[],"receivingPartyPhone":"1321312312"}]}
     * ts : 1533778197730
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
         * total : 1
         * pages : 1
         * rows : [{"id":"40288ac764ef59f20164ef5f6cbb0006","outTreasuryCode":"CK00000133","receivingPartyCode":"MD00000053","receivingPartyId":"1388","receivingPartyName":"经销商测试终端","shipperId":"a993e7628f3d11e8ac060cc47a800cec","shipperCode":"10003480","shipperName":"金华市开发区金谷粮油有限公司","shipperPhone":"135545646911","status":1,"outTime":null,"operationName":"刘程","customerId":null,"createDate":1533024366000,"createName":"刘程","updateDate":1533024367000,"updateName":"刘程","cusIds":[],"receivingPartyPhone":"1321312312"}]
         */

        private String total;
        private String pages;
        private List<RowsBean> rows;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * id : 40288ac764ef59f20164ef5f6cbb0006
             * outTreasuryCode : CK00000133
             * receivingPartyCode : MD00000053
             * receivingPartyId : 1388
             * receivingPartyName : 经销商测试终端
             * shipperId : a993e7628f3d11e8ac060cc47a800cec
             * shipperCode : 10003480
             * shipperName : 金华市开发区金谷粮油有限公司
             * shipperPhone : 135545646911
             * status : 1
             * outTime : null
             * operationName : 刘程
             * customerId : null
             * createDate : 1533024366000
             * createName : 刘程
             * updateDate : 1533024367000
             * updateName : 刘程
             * cusIds : []
             * receivingPartyPhone : 1321312312
             */

            private String id;
            private String outTreasuryCode;
            private String receivingPartyCode;
            private String receivingPartyId;
            private String receivingPartyName;
            private String shipperId;
            private String shipperCode;
            private String shipperName;
            private String shipperPhone;
            private int status;
            private Object outTime;
            private String operationName;
            private Object customerId;
            private long createDate;
            private String createName;
            private long updateDate;
            private String updateName;
            private String receivingPartyPhone;
            private List<?> cusIds;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOutTreasuryCode() {
                return outTreasuryCode;
            }

            public void setOutTreasuryCode(String outTreasuryCode) {
                this.outTreasuryCode = outTreasuryCode;
            }

            public String getReceivingPartyCode() {
                return receivingPartyCode;
            }

            public void setReceivingPartyCode(String receivingPartyCode) {
                this.receivingPartyCode = receivingPartyCode;
            }

            public String getReceivingPartyId() {
                return receivingPartyId;
            }

            public void setReceivingPartyId(String receivingPartyId) {
                this.receivingPartyId = receivingPartyId;
            }

            public String getReceivingPartyName() {
                return receivingPartyName;
            }

            public void setReceivingPartyName(String receivingPartyName) {
                this.receivingPartyName = receivingPartyName;
            }

            public String getShipperId() {
                return shipperId;
            }

            public void setShipperId(String shipperId) {
                this.shipperId = shipperId;
            }

            public String getShipperCode() {
                return shipperCode;
            }

            public void setShipperCode(String shipperCode) {
                this.shipperCode = shipperCode;
            }

            public String getShipperName() {
                return shipperName;
            }

            public void setShipperName(String shipperName) {
                this.shipperName = shipperName;
            }

            public String getShipperPhone() {
                return shipperPhone;
            }

            public void setShipperPhone(String shipperPhone) {
                this.shipperPhone = shipperPhone;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public Object getOutTime() {
                return outTime;
            }

            public void setOutTime(Object outTime) {
                this.outTime = outTime;
            }

            public String getOperationName() {
                return operationName;
            }

            public void setOperationName(String operationName) {
                this.operationName = operationName;
            }

            public Object getCustomerId() {
                return customerId;
            }

            public void setCustomerId(Object customerId) {
                this.customerId = customerId;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public String getCreateName() {
                return createName;
            }

            public void setCreateName(String createName) {
                this.createName = createName;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public String getUpdateName() {
                return updateName;
            }

            public void setUpdateName(String updateName) {
                this.updateName = updateName;
            }

            public String getReceivingPartyPhone() {
                return receivingPartyPhone;
            }

            public void setReceivingPartyPhone(String receivingPartyPhone) {
                this.receivingPartyPhone = receivingPartyPhone;
            }

            public List<?> getCusIds() {
                return cusIds;
            }

            public void setCusIds(List<?> cusIds) {
                this.cusIds = cusIds;
            }
        }
    }
}
