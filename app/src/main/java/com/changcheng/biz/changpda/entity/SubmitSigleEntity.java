package com.changcheng.biz.changpda.entity;

public class SubmitSigleEntity {
    /**
     * code : 200
     * msg : 提交成功
     * data : {"inventory":{"id":"40288adf65231468016527163a80005e","inventoryNumber":"PD00000190","customerId":"a992c35f8f3d11e8ac060cc47a800cec","customerCode":"10002149","customerName":"北京东城糖业烟酒有限公司","mobilephone":"1212131313","inventoryName":"成A七月单盘","inventoryType":0,"status":2,"createName":"李四","createDate":1533959093000,"updateName":null,"updateDate":1533969086488}}
     * ts : 1533969086635
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
         * inventory : {"id":"40288adf65231468016527163a80005e","inventoryNumber":"PD00000190","customerId":"a992c35f8f3d11e8ac060cc47a800cec","customerCode":"10002149","customerName":"北京东城糖业烟酒有限公司","mobilephone":"1212131313","inventoryName":"成A七月单盘","inventoryType":0,"status":2,"createName":"李四","createDate":1533959093000,"updateName":null,"updateDate":1533969086488}
         */

        private InventoryBean inventory;

        public InventoryBean getInventory() {
            return inventory;
        }

        public void setInventory(InventoryBean inventory) {
            this.inventory = inventory;
        }

        public static class InventoryBean {
            /**
             * id : 40288adf65231468016527163a80005e
             * inventoryNumber : PD00000190
             * customerId : a992c35f8f3d11e8ac060cc47a800cec
             * customerCode : 10002149
             * customerName : 北京东城糖业烟酒有限公司
             * mobilephone : 1212131313
             * inventoryName : 成A七月单盘
             * inventoryType : 0
             * status : 2
             * createName : 李四
             * createDate : 1533959093000
             * updateName : null
             * updateDate : 1533969086488
             */

            private String id;
            private String inventoryNumber;
            private String customerId;
            private String customerCode;
            private String customerName;
            private String mobilephone;
            private String inventoryName;
            private int inventoryType;
            private int status;
            private String createName;
            private long createDate;
            private Object updateName;
            private long updateDate;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getInventoryNumber() {
                return inventoryNumber;
            }

            public void setInventoryNumber(String inventoryNumber) {
                this.inventoryNumber = inventoryNumber;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getCustomerCode() {
                return customerCode;
            }

            public void setCustomerCode(String customerCode) {
                this.customerCode = customerCode;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getMobilephone() {
                return mobilephone;
            }

            public void setMobilephone(String mobilephone) {
                this.mobilephone = mobilephone;
            }

            public String getInventoryName() {
                return inventoryName;
            }

            public void setInventoryName(String inventoryName) {
                this.inventoryName = inventoryName;
            }

            public int getInventoryType() {
                return inventoryType;
            }

            public void setInventoryType(int inventoryType) {
                this.inventoryType = inventoryType;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCreateName() {
                return createName;
            }

            public void setCreateName(String createName) {
                this.createName = createName;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public Object getUpdateName() {
                return updateName;
            }

            public void setUpdateName(Object updateName) {
                this.updateName = updateName;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }
        }
    }
}
