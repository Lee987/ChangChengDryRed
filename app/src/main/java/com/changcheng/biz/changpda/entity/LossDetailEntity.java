package com.changcheng.biz.changpda.entity;

import java.util.List;

public class LossDetailEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : [{"id":"40288a696541b20d016541c1d7450070","reportLossId":null,"reportLossCode":"BS00000156","commodityCode":"1011121910","commodityName":"沙城长城皇家礼盒干红750ML*2*5（删）","commodityUnit":"2","commodityId":null,"quantity":3,"scanQuantity":null,"isScan":0,"creatName":null,"updateName":"李四","createDate":1534406547000,"updateDate":1534406547000,"stockNum":1}]
     * ts : 1534406869995
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
         * id : 40288a696541b20d016541c1d7450070
         * reportLossId : null
         * reportLossCode : BS00000156
         * commodityCode : 1011121910
         * commodityName : 沙城长城皇家礼盒干红750ML*2*5（删）
         * commodityUnit : 2
         * commodityId : null
         * quantity : 3
         * scanQuantity : null
         * isScan : 0
         * creatName : null
         * updateName : 李四
         * createDate : 1534406547000
         * updateDate : 1534406547000
         * stockNum : 1
         */

        private String id;
        private Object reportLossId;
        private String reportLossCode;
        private String commodityCode;
        private String commodityName;
        private String commodityUnit;
        private Object commodityId;
        private int quantity;
        private Object scanQuantity;
        private int isScan;
        private Object creatName;
        private String updateName;
        private long createDate;
        private long updateDate;
        private int stockNum;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getReportLossId() {
            return reportLossId;
        }

        public void setReportLossId(Object reportLossId) {
            this.reportLossId = reportLossId;
        }

        public String getReportLossCode() {
            return reportLossCode;
        }

        public void setReportLossCode(String reportLossCode) {
            this.reportLossCode = reportLossCode;
        }

        public String getCommodityCode() {
            return commodityCode;
        }

        public void setCommodityCode(String commodityCode) {
            this.commodityCode = commodityCode;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getCommodityUnit() {
            return commodityUnit;
        }

        public void setCommodityUnit(String commodityUnit) {
            this.commodityUnit = commodityUnit;
        }

        public Object getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(Object commodityId) {
            this.commodityId = commodityId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Object getScanQuantity() {
            return scanQuantity;
        }

        public void setScanQuantity(Object scanQuantity) {
            this.scanQuantity = scanQuantity;
        }

        public int getIsScan() {
            return isScan;
        }

        public void setIsScan(int isScan) {
            this.isScan = isScan;
        }

        public Object getCreatName() {
            return creatName;
        }

        public void setCreatName(Object creatName) {
            this.creatName = creatName;
        }

        public String getUpdateName() {
            return updateName;
        }

        public void setUpdateName(String updateName) {
            this.updateName = updateName;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public long getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(long updateDate) {
            this.updateDate = updateDate;
        }

        public int getStockNum() {
            return stockNum;
        }

        public void setStockNum(int stockNum) {
            this.stockNum = stockNum;
        }
    }
}
