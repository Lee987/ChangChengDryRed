package com.changcheng.biz.changpda.entity;

import java.util.List;

public class InventoryEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"total":"103","pages":"1","list":[{"id":"40288adf6518956401651d9e448b004e","inventoryNumber":"PD00000174","customerId":"a992c35f8f3d11e8ac060cc47a800cec","customerCode":"10002149","customerName":"北京东城糖业烟酒有限公司","mobilephone":"1212131313","inventoryName":"成A七月单盘","inventoryType":0,"status":2,"createName":"李四","createDate":1533800236000,"updateName":null,"updateDate":1533800414000,"customerIds":null}],"rows":"1"}
     * ts : 1533866411459
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
         * total : 103
         * pages : 1
         * list : [{"id":"40288adf6518956401651d9e448b004e","inventoryNumber":"PD00000174","customerId":"a992c35f8f3d11e8ac060cc47a800cec","customerCode":"10002149","customerName":"北京东城糖业烟酒有限公司","mobilephone":"1212131313","inventoryName":"成A七月单盘","inventoryType":0,"status":2,"createName":"李四","createDate":1533800236000,"updateName":null,"updateDate":1533800414000,"customerIds":null}]
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
             * id : 40288adf6518956401651d9e448b004e
             * inventoryNumber : PD00000174
             * customerId : a992c35f8f3d11e8ac060cc47a800cec
             * customerCode : 10002149
             * customerName : 北京东城糖业烟酒有限公司
             * mobilephone : 1212131313
             * inventoryName : 成A七月单盘
             * inventoryType : 0
             * status : 2
             * createName : 李四
             * createDate : 1533800236000
             * updateName : null
             * updateDate : 1533800414000
             * customerIds : null
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
            private Object customerIds;

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

            public Object getCustomerIds() {
                return customerIds;
            }

            public void setCustomerIds(Object customerIds) {
                this.customerIds = customerIds;
            }
        }
    }
}
