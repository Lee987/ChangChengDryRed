package com.changcheng.biz.changpda.entity;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class GoodsEntity implements Serializable{
    /**
     * code : 200
     * msg : 操作成功
     * data : {"total":"10","pages":"1","rows":[{"id":"828c703f8f4e11e8ac060cc47a800cec","productCode":"1031114516","productName":"烟台长城经典金庄干红7878/750ML*1*6","level1":null,"levelCode1":null,"level2":null,"levelCode2":null,"level3":null,"levelCode3":null,"level4":null,"levelCode4":null,"level5":null,"levelCode5":null,"productUnit":"2","productStand":"750ML*1*6","isScan":"1","updateName":"超级管理员(系统管理员)","updateDate":1532442798000,"enableStatus":0,"stockNum":12,"notExistsCodes":null,"productImg":null,"productUrl":null}]}
     * ts : 1533803664383
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

    public static class DataBean implements Serializable{
        /**
         * total : 10
         * pages : 1
         * rows : [{"id":"828c703f8f4e11e8ac060cc47a800cec","productCode":"1031114516","productName":"烟台长城经典金庄干红7878/750ML*1*6","level1":null,"levelCode1":null,"level2":null,"levelCode2":null,"level3":null,"levelCode3":null,"level4":null,"levelCode4":null,"level5":null,"levelCode5":null,"productUnit":"2","productStand":"750ML*1*6","isScan":"1","updateName":"超级管理员(系统管理员)","updateDate":1532442798000,"enableStatus":0,"stockNum":12,"notExistsCodes":null,"productImg":null,"productUrl":null}]
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

        public static class RowsBean implements Serializable{
            /**
             * id : 828c703f8f4e11e8ac060cc47a800cec
             * productCode : 1031114516
             * productName : 烟台长城经典金庄干红7878/750ML*1*6
             * level1 : null
             * levelCode1 : null
             * level2 : null
             * levelCode2 : null
             * level3 : null
             * levelCode3 : null
             * level4 : null
             * levelCode4 : null
             * level5 : null
             * levelCode5 : null
             * productUnit : 2
             * productStand : 750ML*1*6
             * isScan : 1
             * updateName : 超级管理员(系统管理员)
             * updateDate : 1532442798000
             * enableStatus : 0
             * stockNum : 12
             * notExistsCodes : null
             * productImg : null
             * productUrl : null
             *
             */

            private String id;
            private String productCode;
            private String productName;
            private Object level1;
            private Object levelCode1;
            private Object level2;
            private Object levelCode2;
            private Object level3;
            private Object levelCode3;
            private Object level4;
            private Object levelCode4;
            private Object level5;
            private Object levelCode5;
            private String productUnit;
            private String productStand;
            private String isScan;
            private String updateName;
            private long updateDate;
            private int enableStatus;
            private int stockNum;
            private Object notExistsCodes;
            private Object productImg;
            private Object productUrl;
            private boolean isCheck;
            private int numbers;

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

            public Object getLevel1() {
                return level1;
            }

            public void setLevel1(Object level1) {
                this.level1 = level1;
            }

            public Object getLevelCode1() {
                return levelCode1;
            }

            public void setLevelCode1(Object levelCode1) {
                this.levelCode1 = levelCode1;
            }

            public Object getLevel2() {
                return level2;
            }

            public void setLevel2(Object level2) {
                this.level2 = level2;
            }

            public Object getLevelCode2() {
                return levelCode2;
            }

            public void setLevelCode2(Object levelCode2) {
                this.levelCode2 = levelCode2;
            }

            public Object getLevel3() {
                return level3;
            }

            public void setLevel3(Object level3) {
                this.level3 = level3;
            }

            public Object getLevelCode3() {
                return levelCode3;
            }

            public void setLevelCode3(Object levelCode3) {
                this.levelCode3 = levelCode3;
            }

            public Object getLevel4() {
                return level4;
            }

            public void setLevel4(Object level4) {
                this.level4 = level4;
            }

            public Object getLevelCode4() {
                return levelCode4;
            }

            public void setLevelCode4(Object levelCode4) {
                this.levelCode4 = levelCode4;
            }

            public Object getLevel5() {
                return level5;
            }

            public void setLevel5(Object level5) {
                this.level5 = level5;
            }

            public Object getLevelCode5() {
                return levelCode5;
            }

            public void setLevelCode5(Object levelCode5) {
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

            public int getStockNum() {
                return stockNum;
            }

            public void setStockNum(int stockNum) {
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

            public int getNumbers() {
                return numbers;
            }

            public void setNumbers(int numbers) {
                this.numbers = numbers;
            }
        }
    }
}
