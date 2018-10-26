package com.changcheng.biz.changpda.entity;

import java.util.List;

public class InvtDetailEntity {
    /**
     * code : 200
     * msg : 操作成功
     * data : {"total":"9","inventory":{"id":"40288adf65189564016518e661df003a","inventoryNumber":"PD00000173","customerId":"a992c35f8f3d11e8ac060cc47a800cec","customerCode":"10002149","customerName":"北京东城糖业烟酒有限公司","mobilephone":"1212131313","inventoryName":"成A七月全盘","inventoryType":1,"status":2,"createName":"李四","createDate":1533721076000,"updateName":null,"updateDate":1533721334000,"customerIds":null},"pages":"1","inventoryDetail":[{"id":"40288adf65189564016518e661720031","inventoryNumber":"PD00000173","productId":"828c703f8f4e11e8ac060cc47a800cec","productCode":"1031114516","productName":"烟台长城经典金庄干红7878/750ML*1*6","productUnit":"2","numbers":110,"isScan":"1","inventoryBeforeStock":110,"inventoryAfterStock":110,"changeStock":0,"createName":"李四","createDate":1533721076000,"updateName":null,"updateDate":1533721334000,"isTemp":null}],"rows":"1"}
     * ts : 1533871247775
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
         * total : 9
         * inventory : {"id":"40288adf65189564016518e661df003a","inventoryNumber":"PD00000173","customerId":"a992c35f8f3d11e8ac060cc47a800cec","customerCode":"10002149","customerName":"北京东城糖业烟酒有限公司","mobilephone":"1212131313","inventoryName":"成A七月全盘","inventoryType":1,"status":2,"createName":"李四","createDate":1533721076000,"updateName":null,"updateDate":1533721334000,"customerIds":null}
         * pages : 1
         * inventoryDetail : [{"id":"40288adf65189564016518e661720031","inventoryNumber":"PD00000173","productId":"828c703f8f4e11e8ac060cc47a800cec","productCode":"1031114516","productName":"烟台长城经典金庄干红7878/750ML*1*6","productUnit":"2","numbers":110,"isScan":"1","inventoryBeforeStock":110,"inventoryAfterStock":110,"changeStock":0,"createName":"李四","createDate":1533721076000,"updateName":null,"updateDate":1533721334000,"isTemp":null}]
         * rows : 1
         */

        private String total;
        private InventoryBean inventory;
        private String pages;
        private String rows;
        private List<InventoryDetailBean> inventoryDetail;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public InventoryBean getInventory() {
            return inventory;
        }

        public void setInventory(InventoryBean inventory) {
            this.inventory = inventory;
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

        public List<InventoryDetailBean> getInventoryDetail() {
            return inventoryDetail;
        }

        public void setInventoryDetail(List<InventoryDetailBean> inventoryDetail) {
            this.inventoryDetail = inventoryDetail;
        }

        public static class InventoryBean {
            /**
             * id : 40288adf65189564016518e661df003a
             * inventoryNumber : PD00000173
             * customerId : a992c35f8f3d11e8ac060cc47a800cec
             * customerCode : 10002149
             * customerName : 北京东城糖业烟酒有限公司
             * mobilephone : 1212131313
             * inventoryName : 成A七月全盘
             * inventoryType : 1
             * status : 2
             * createName : 李四
             * createDate : 1533721076000
             * updateName : null
             * updateDate : 1533721334000
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

        public static class InventoryDetailBean {
            /**
             * id : 40288adf65189564016518e661720031
             * inventoryNumber : PD00000173
             * productId : 828c703f8f4e11e8ac060cc47a800cec
             * productCode : 1031114516
             * productName : 烟台长城经典金庄干红7878/750ML*1*6
             * productUnit : 2
             * numbers : 110
             * isScan : 1
             * inventoryBeforeStock : 110
             * inventoryAfterStock : 110
             * changeStock : 0
             * createName : 李四
             * createDate : 1533721076000
             * updateName : null
             * updateDate : 1533721334000
             * isTemp : null
             */

            private String id;
            private String inventoryNumber;
            private String productId;
            private String productCode;
            private String productName;
            private String productUnit;
            private int numbers;
            private String isScan;
            private int inventoryBeforeStock;
            private int inventoryAfterStock;
            private int changeStock;
            private String createName;
            private long createDate;
            private Object updateName;
            private long updateDate;
            private Object isTemp;

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

            public int getNumbers() {
                return numbers;
            }

            public void setNumbers(int numbers) {
                this.numbers = numbers;
            }

            public String getIsScan() {
                return isScan;
            }

            public void setIsScan(String isScan) {
                this.isScan = isScan;
            }

            public int getInventoryBeforeStock() {
                return inventoryBeforeStock;
            }

            public void setInventoryBeforeStock(int inventoryBeforeStock) {
                this.inventoryBeforeStock = inventoryBeforeStock;
            }

            public int getInventoryAfterStock() {
                return inventoryAfterStock;
            }

            public void setInventoryAfterStock(int inventoryAfterStock) {
                this.inventoryAfterStock = inventoryAfterStock;
            }

            public int getChangeStock() {
                return changeStock;
            }

            public void setChangeStock(int changeStock) {
                this.changeStock = changeStock;
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

            public Object getIsTemp() {
                return isTemp;
            }

            public void setIsTemp(Object isTemp) {
                this.isTemp = isTemp;
            }
        }
    }
}
