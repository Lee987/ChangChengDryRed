package com.changcheng.biz.changpda.entity;

import java.util.List;

public class OutStorDetailEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"total":"1","pages":"1","rows":[{"id":"40288a696531d582016531e921e20001","outTreasuryId":"40288a696531d582016531e921d70000","outTreasuryCode":"CK00000189","productId":"81e47e958f4e11e8ac060cc47a800cec","productCode":"1011119910","productName":"沙城长城荣耀绽放A版礼盒750ML*2*5","productUnit":"2","productNum":66,"temStatus":1,"isScan":"0","scanNum":null,"createDate":1534140687000,"createName":null,"updateDate":1534140687000,"updateName":null,"stockNum":null}]}
     * ts : 1534141206282
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
         * rows : [{"id":"40288a696531d582016531e921e20001","outTreasuryId":"40288a696531d582016531e921d70000","outTreasuryCode":"CK00000189","productId":"81e47e958f4e11e8ac060cc47a800cec","productCode":"1011119910","productName":"沙城长城荣耀绽放A版礼盒750ML*2*5","productUnit":"2","productNum":66,"temStatus":1,"isScan":"0","scanNum":null,"createDate":1534140687000,"createName":null,"updateDate":1534140687000,"updateName":null,"stockNum":null}]
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
             * id : 40288a696531d582016531e921e20001
             * outTreasuryId : 40288a696531d582016531e921d70000
             * outTreasuryCode : CK00000189
             * productId : 81e47e958f4e11e8ac060cc47a800cec
             * productCode : 1011119910
             * productName : 沙城长城荣耀绽放A版礼盒750ML*2*5
             * productUnit : 2
             * productNum : 66
             * temStatus : 1
             * isScan : 0
             * scanNum : null
             * createDate : 1534140687000
             * createName : null
             * updateDate : 1534140687000
             * updateName : null
             * stockNum : null
             */

            private String id;
            private String outTreasuryId;
            private String outTreasuryCode;
            private String productId;
            private String productCode;
            private String productName;
            private String productUnit;
            private int productNum;
            private int temStatus;
            private String isScan;
            private Object scanNum;
            private long createDate;
            private Object createName;
            private long updateDate;
            private Object updateName;
            private Object stockNum;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOutTreasuryId() {
                return outTreasuryId;
            }

            public void setOutTreasuryId(String outTreasuryId) {
                this.outTreasuryId = outTreasuryId;
            }

            public String getOutTreasuryCode() {
                return outTreasuryCode;
            }

            public void setOutTreasuryCode(String outTreasuryCode) {
                this.outTreasuryCode = outTreasuryCode;
            }

            public String getProductId() {
                return productId;
            }

            public void setProductId(String productId) {
                this.productId = productId;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductUnit() {
                return productUnit;
            }

            public void setProductUnit(String productUnit) {
                this.productUnit = productUnit;
            }

            public int getProductNum() {
                return productNum;
            }

            public void setProductNum(int productNum) {
                this.productNum = productNum;
            }

            public int getTemStatus() {
                return temStatus;
            }

            public void setTemStatus(int temStatus) {
                this.temStatus = temStatus;
            }

            public String getIsScan() {
                return isScan;
            }

            public void setIsScan(String isScan) {
                this.isScan = isScan;
            }

            public Object getScanNum() {
                return scanNum;
            }

            public void setScanNum(Object scanNum) {
                this.scanNum = scanNum;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public Object getCreateName() {
                return createName;
            }

            public void setCreateName(Object createName) {
                this.createName = createName;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public Object getUpdateName() {
                return updateName;
            }

            public void setUpdateName(Object updateName) {
                this.updateName = updateName;
            }

            public Object getStockNum() {
                return stockNum;
            }

            public void setStockNum(Object stockNum) {
                this.stockNum = stockNum;
            }
        }
    }
}
