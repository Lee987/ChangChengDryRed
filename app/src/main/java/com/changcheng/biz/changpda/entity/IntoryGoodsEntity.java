package com.changcheng.biz.changpda.entity;

import java.util.List;

public class IntoryGoodsEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"total":"2573","pages":"1","list":[{"id":"81e47e958f4e11e8ac060cc47a800cec","productCode":"1011119910","productName":"沙城长城荣耀绽放A版礼盒750ML*2*5","level1":"酒类","levelCode1":"10","level2":"长城葡萄酒","levelCode2":"10001","level3":"DE类","levelCode3":"10001026","level4":"DE类","levelCode4":"1000102600003","level5":"普通DE","levelCode5":"100010260000300002","productUnit":"2","productStand":"750ML*2*5","isScan":"0","updateName":"超级管理员(系统管理员)","updateDate":1532442798000,"enableStatus":0,"stockNum":null,"notExistsCodes":null,"productImg":null,"productUrl":null}],"rows":"1"}
     * ts : 1533889877871
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
         * total : 2573
         * pages : 1
         * list : [{"id":"81e47e958f4e11e8ac060cc47a800cec","productCode":"1011119910","productName":"沙城长城荣耀绽放A版礼盒750ML*2*5","level1":"酒类","levelCode1":"10","level2":"长城葡萄酒","levelCode2":"10001","level3":"DE类","levelCode3":"10001026","level4":"DE类","levelCode4":"1000102600003","level5":"普通DE","levelCode5":"100010260000300002","productUnit":"2","productStand":"750ML*2*5","isScan":"0","updateName":"超级管理员(系统管理员)","updateDate":1532442798000,"enableStatus":0,"stockNum":null,"notExistsCodes":null,"productImg":null,"productUrl":null}]
         * rows : 1
         */

        private String total;
        private String pages;
        private String rows;
        private List<ListBean> list;

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

        public String getRows() {
            return rows;
        }

        public void setRows(String rows) {
            this.rows = rows;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 81e47e958f4e11e8ac060cc47a800cec
             * productCode : 1011119910
             * productName : 沙城长城荣耀绽放A版礼盒750ML*2*5
             * level1 : 酒类
             * levelCode1 : 10
             * level2 : 长城葡萄酒
             * levelCode2 : 10001
             * level3 : DE类
             * levelCode3 : 10001026
             * level4 : DE类
             * levelCode4 : 1000102600003
             * level5 : 普通DE
             * levelCode5 : 100010260000300002
             * productUnit : 2
             * productStand : 750ML*2*5
             * isScan : 0
             * updateName : 超级管理员(系统管理员)
             * updateDate : 1532442798000
             * enableStatus : 0
             * stockNum : null
             * notExistsCodes : null
             * productImg : null
             * productUrl : null
             */

            private String id;
            private String productCode;
            private String productName;
            private String level1;
            private String levelCode1;
            private String level2;
            private String levelCode2;
            private String level3;
            private String levelCode3;
            private String level4;
            private String levelCode4;
            private String level5;
            private String levelCode5;
            private String productUnit;
            private String productStand;
            private String isScan;
            private String updateName;
            private long updateDate;
            private int enableStatus;
            private Object stockNum;
            private Object notExistsCodes;
            private Object productImg;
            private Object productUrl;
            private boolean isCheck;

            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getLevel1() {
                return level1;
            }

            public void setLevel1(String level1) {
                this.level1 = level1;
            }

            public String getLevelCode1() {
                return levelCode1;
            }

            public void setLevelCode1(String levelCode1) {
                this.levelCode1 = levelCode1;
            }

            public String getLevel2() {
                return level2;
            }

            public void setLevel2(String level2) {
                this.level2 = level2;
            }

            public String getLevelCode2() {
                return levelCode2;
            }

            public void setLevelCode2(String levelCode2) {
                this.levelCode2 = levelCode2;
            }

            public String getLevel3() {
                return level3;
            }

            public void setLevel3(String level3) {
                this.level3 = level3;
            }

            public String getLevelCode3() {
                return levelCode3;
            }

            public void setLevelCode3(String levelCode3) {
                this.levelCode3 = levelCode3;
            }

            public String getLevel4() {
                return level4;
            }

            public void setLevel4(String level4) {
                this.level4 = level4;
            }

            public String getLevelCode4() {
                return levelCode4;
            }

            public void setLevelCode4(String levelCode4) {
                this.levelCode4 = levelCode4;
            }

            public String getLevel5() {
                return level5;
            }

            public void setLevel5(String level5) {
                this.level5 = level5;
            }

            public String getLevelCode5() {
                return levelCode5;
            }

            public void setLevelCode5(String levelCode5) {
                this.levelCode5 = levelCode5;
            }

            public String getProductUnit() {
                return productUnit;
            }

            public void setProductUnit(String productUnit) {
                this.productUnit = productUnit;
            }

            public String getProductStand() {
                return productStand;
            }

            public void setProductStand(String productStand) {
                this.productStand = productStand;
            }

            public String getIsScan() {
                return isScan;
            }

            public void setIsScan(String isScan) {
                this.isScan = isScan;
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

            public int getEnableStatus() {
                return enableStatus;
            }

            public void setEnableStatus(int enableStatus) {
                this.enableStatus = enableStatus;
            }

            public Object getStockNum() {
                return stockNum;
            }

            public void setStockNum(Object stockNum) {
                this.stockNum = stockNum;
            }

            public Object getNotExistsCodes() {
                return notExistsCodes;
            }

            public void setNotExistsCodes(Object notExistsCodes) {
                this.notExistsCodes = notExistsCodes;
            }

            public Object getProductImg() {
                return productImg;
            }

            public void setProductImg(Object productImg) {
                this.productImg = productImg;
            }

            public Object getProductUrl() {
                return productUrl;
            }

            public void setProductUrl(Object productUrl) {
                this.productUrl = productUrl;
            }
        }
    }
}
