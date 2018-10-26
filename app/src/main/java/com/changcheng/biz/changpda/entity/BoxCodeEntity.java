package com.changcheng.biz.changpda.entity;

public class BoxCodeEntity {
    /**
     * code : 200
     * data : {"id":"fdc085d264f4f42e0164f508be350000","bottleCode":"01000002905194416A6F","boxCode":"0110141117262018003B025671715441","laserCode":"01B01806600714543713","proCode":"1011121910","proName":"沙城长城皇家礼盒干红750ML*2*5（删）","proBatchNum":"003B02","proDate":"2018-06-05 11:23:00","terminalId":2335,"terminalPurchaseCode":"XSCK100000000001","terminalPurchaseDate":"2018-08-24 16:20:23.0","productImg":"1535121168979_6c757e9c-dd54-44de-a78f-a90e4dd3c7c4_Penguins.jpg"}
     * ts : 1540517953512
     */

    private String code;
    private DataBean data;
    private long ts;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
         * id : fdc085d264f4f42e0164f508be350000
         * bottleCode : 01000002905194416A6F
         * boxCode : 0110141117262018003B025671715441
         * laserCode : 01B01806600714543713
         * proCode : 1011121910
         * proName : 沙城长城皇家礼盒干红750ML*2*5（删）
         * proBatchNum : 003B02
         * proDate : 2018-06-05 11:23:00
         * terminalId : 2335
         * terminalPurchaseCode : XSCK100000000001
         * terminalPurchaseDate : 2018-08-24 16:20:23.0
         * productImg : 1535121168979_6c757e9c-dd54-44de-a78f-a90e4dd3c7c4_Penguins.jpg
         */

        private String id;
        private String bottleCode;
        private String boxCode;
        private String laserCode;
        private String proCode;
        private String proName;
        private String proBatchNum;
        private String proDate;
        private int terminalId;
        private String terminalPurchaseCode;
        private String terminalPurchaseDate;
        private String productImg;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBottleCode() {
            return bottleCode;
        }

        public void setBottleCode(String bottleCode) {
            this.bottleCode = bottleCode;
        }

        public String getBoxCode() {
            return boxCode;
        }

        public void setBoxCode(String boxCode) {
            this.boxCode = boxCode;
        }

        public String getLaserCode() {
            return laserCode;
        }

        public void setLaserCode(String laserCode) {
            this.laserCode = laserCode;
        }

        public String getProCode() {
            return proCode;
        }

        public void setProCode(String proCode) {
            this.proCode = proCode;
        }

        public String getProName() {
            return proName;
        }

        public void setProName(String proName) {
            this.proName = proName;
        }

        public String getProBatchNum() {
            return proBatchNum;
        }

        public void setProBatchNum(String proBatchNum) {
            this.proBatchNum = proBatchNum;
        }

        public String getProDate() {
            return proDate;
        }

        public void setProDate(String proDate) {
            this.proDate = proDate;
        }

        public int getTerminalId() {
            return terminalId;
        }

        public void setTerminalId(int terminalId) {
            this.terminalId = terminalId;
        }

        public String getTerminalPurchaseCode() {
            return terminalPurchaseCode;
        }

        public void setTerminalPurchaseCode(String terminalPurchaseCode) {
            this.terminalPurchaseCode = terminalPurchaseCode;
        }

        public String getTerminalPurchaseDate() {
            return terminalPurchaseDate;
        }

        public void setTerminalPurchaseDate(String terminalPurchaseDate) {
            this.terminalPurchaseDate = terminalPurchaseDate;
        }

        public String getProductImg() {
            return productImg;
        }

        public void setProductImg(String productImg) {
            this.productImg = productImg;
        }
    }
}
