package com.changcheng.biz.changpda.entity;

import java.util.List;

public class ReturnGoodsEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"total":"4","pages":"1","rows":[{"id":"297eaed864d452380164d467f8020009","returnGoodsCode":"TH00000031","receivingPartyName":"rwerwe","returnPartyId":"a992c35f8f3d11e8ac060cc47a800cec","returnPartyCode":"10002149","returnPartyName":"北京东城糖业烟酒有限公司","returnPartyPhone":null,"status":1,"returnTime":null,"operationName":"李四","createDate":1532571941000,"createName":"李四(null)","updateDate":1532571941000,"updateName":"李四(null)","cusIds":[],"customerId":null}]}
     * ts : 1533887788438
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
         * total : 4
         * pages : 1
         * rows : [{"id":"297eaed864d452380164d467f8020009","returnGoodsCode":"TH00000031","receivingPartyName":"rwerwe","returnPartyId":"a992c35f8f3d11e8ac060cc47a800cec","returnPartyCode":"10002149","returnPartyName":"北京东城糖业烟酒有限公司","returnPartyPhone":null,"status":1,"returnTime":null,"operationName":"李四","createDate":1532571941000,"createName":"李四(null)","updateDate":1532571941000,"updateName":"李四(null)","cusIds":[],"customerId":null}]
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
             * id : 297eaed864d452380164d467f8020009
             * returnGoodsCode : TH00000031
             * receivingPartyName : rwerwe
             * returnPartyId : a992c35f8f3d11e8ac060cc47a800cec
             * returnPartyCode : 10002149
             * returnPartyName : 北京东城糖业烟酒有限公司
             * returnPartyPhone : null
             * status : 1
             * returnTime : null
             * operationName : 李四
             * createDate : 1532571941000
             * createName : 李四(null)
             * updateDate : 1532571941000
             * updateName : 李四(null)
             * cusIds : []
             * customerId : null
             */

            private String id;
            private String returnGoodsCode;
            private String receivingPartyName;
            private String returnPartyId;
            private String returnPartyCode;
            private String returnPartyName;
            private Object returnPartyPhone;
            private int status;
            private Object returnTime;
            private String operationName;
            private long createDate;
            private String createName;
            private long updateDate;
            private String updateName;
            private Object customerId;
            private List<?> cusIds;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getReturnGoodsCode() {
                return returnGoodsCode;
            }

            public void setReturnGoodsCode(String returnGoodsCode) {
                this.returnGoodsCode = returnGoodsCode;
            }

            public String getReceivingPartyName() {
                return receivingPartyName;
            }

            public void setReceivingPartyName(String receivingPartyName) {
                this.receivingPartyName = receivingPartyName;
            }

            public String getReturnPartyId() {
                return returnPartyId;
            }

            public void setReturnPartyId(String returnPartyId) {
                this.returnPartyId = returnPartyId;
            }

            public String getReturnPartyCode() {
                return returnPartyCode;
            }

            public void setReturnPartyCode(String returnPartyCode) {
                this.returnPartyCode = returnPartyCode;
            }

            public String getReturnPartyName() {
                return returnPartyName;
            }

            public void setReturnPartyName(String returnPartyName) {
                this.returnPartyName = returnPartyName;
            }

            public Object getReturnPartyPhone() {
                return returnPartyPhone;
            }

            public void setReturnPartyPhone(Object returnPartyPhone) {
                this.returnPartyPhone = returnPartyPhone;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public Object getReturnTime() {
                return returnTime;
            }

            public void setReturnTime(Object returnTime) {
                this.returnTime = returnTime;
            }

            public String getOperationName() {
                return operationName;
            }

            public void setOperationName(String operationName) {
                this.operationName = operationName;
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

            public Object getCustomerId() {
                return customerId;
            }

            public void setCustomerId(Object customerId) {
                this.customerId = customerId;
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
