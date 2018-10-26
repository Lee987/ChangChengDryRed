package com.changcheng.biz.changpda.entity;

import java.util.List;

public class ReceiptDetailEntity {
    /**
     * code : 200
     * msg : 获取数据成功
     * data : [{"id":"fdc085d26532791101653292d33b000c","enterLibraryOrderId":"fdc085d26532791101653292d33a000b","productId":"829ff24d8f4e11e8ac060cc47a800cec","productCode":"1035102916","productName":null,"unit":"2","standard":"750ML*6","number":2700,"createDate":1534151808000,"createName":"超级管理员(特务专员)","updateDate":1534151808000,"updateName":"超级管理员(特务专员)"}]
     * ts : 1534226787169
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
         * id : fdc085d26532791101653292d33b000c
         * enterLibraryOrderId : fdc085d26532791101653292d33a000b
         * productId : 829ff24d8f4e11e8ac060cc47a800cec
         * productCode : 1035102916
         * productName : null
         * unit : 2
         * standard : 750ML*6
         * number : 2700
         * createDate : 1534151808000
         * createName : 超级管理员(特务专员)
         * updateDate : 1534151808000
         * updateName : 超级管理员(特务专员)
         */

        private String id;
        private String enterLibraryOrderId;
        private String productId;
        private String productCode;
        private Object productName;
        private String unit;
        private String standard;
        private int number;
        private long createDate;
        private String createName;
        private long updateDate;
        private String updateName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEnterLibraryOrderId() {
            return enterLibraryOrderId;
        }

        public void setEnterLibraryOrderId(String enterLibraryOrderId) {
            this.enterLibraryOrderId = enterLibraryOrderId;
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

        public Object getProductName() {
            return productName;
        }

        public void setProductName(Object productName) {
            this.productName = productName;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getStandard() {
            return standard;
        }

        public void setStandard(String standard) {
            this.standard = standard;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
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
    }
}
