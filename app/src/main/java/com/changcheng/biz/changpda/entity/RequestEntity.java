package com.changcheng.biz.changpda.entity;

import java.util.List;

public class RequestEntity {
    private String customerId;
    private String custId;
    private String userId;
    private String operactionUserId;
    private String orgId;
    private Integer status;
    private String userName;
    private String createName;
    private String password;
    private String id;
    private String terminalInfoId;
    private String outTreasuryCode;
    private String receivingPartyName;
    private String returnGoodsId;
    private String returnGoodsCode;
    private String deliveryCode;
    private String enterLibraryOrderId;
    private String reportLossCode;
    private String reportLossId;
    private String reportLossType;
    private String inventoryNumber;
    private String boxCode;
    private String customerCode;
    private Boolean ignoreChecked;
    private String outTreasuryId;
    private String productId;
    private String productCode;
    private String tmReportLossId;
    private String productName;
    private String code;
    private String qrCode;
    private Integer type;
    private TmInventoryVo tmInventoryVo;

    private List<TmInventoryDetailVoList> tmInventoryDetailVoList;
    private List<TmOutTreasuryDetails> tmOutTreasuryDetails;
    private List<TmReturnGoodsDetails> tmReturnGoodsDetails;
    private List<ReportLossDetails> reportLossDetails;

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOutTreasuryId() {
        return outTreasuryId;
    }

    public String getProductId() {
        return productId;
    }

    public String getOperactionUserId() {
        return operactionUserId;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setOperactionUserId(String operactionUserId) {
        this.operactionUserId = operactionUserId;
    }

    public String getTmReportLossId() {
        return tmReportLossId;

    }

    public void setTmReportLossId(String tmReportLossId) {
        this.tmReportLossId = tmReportLossId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setOutTreasuryId(String outTreasuryId) {
        this.outTreasuryId = outTreasuryId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUserId() {

        return userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTerminalInfoId() {
        return terminalInfoId;
    }

    public String getEnterLibraryOrderId() {
        return enterLibraryOrderId;
    }

    public void setEnterLibraryOrderId(String enterLibraryOrderId) {
        this.enterLibraryOrderId = enterLibraryOrderId;
    }

    public void setTerminalInfoId(String terminalInfoId) {
        this.terminalInfoId = terminalInfoId;
    }

    public TmInventoryVo getTmInventoryVo() {
        return tmInventoryVo;
    }

    public void setTmInventoryVo(TmInventoryVo tmInventoryVo) {
        this.tmInventoryVo = tmInventoryVo;
    }

    public String getReturnGoodsId() {
        return returnGoodsId;
    }

    public void setReturnGoodsId(String returnGoodsId) {
        this.returnGoodsId = returnGoodsId;
    }

    public String getOutTreasuryCode() {
        return outTreasuryCode;
    }

    public void setOutTreasuryCode(String outTreasuryCode) {
        this.outTreasuryCode = outTreasuryCode;
    }

    public String getReceivingPartyName() {
        return receivingPartyName;
    }

    public String getReturnGoodsCode() {
        return returnGoodsCode;
    }

    public void setReturnGoodsCode(String returnGoodsCode) {
        this.returnGoodsCode = returnGoodsCode;
    }

    public void setReceivingPartyName(String receivingPartyName) {
        this.receivingPartyName = receivingPartyName;

    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getReportLossCode() {
        return reportLossCode;
    }

    public void setReportLossCode(String reportLossCode) {
        this.reportLossCode = reportLossCode;
    }

    public String getReportLossId() {
        return reportLossId;
    }

    public void setReportLossId(String reportLossId) {
        this.reportLossId = reportLossId;
    }

    public String getReportLossType() {
        return reportLossType;
    }

    public void setReportLossType(String reportLossType) {
        this.reportLossType = reportLossType;
    }

    public Boolean getIgnoreChecked() {
        return ignoreChecked;
    }

    public void setIgnoreChecked(Boolean ignoreChecked) {
        this.ignoreChecked = ignoreChecked;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public List<TmReturnGoodsDetails> getTmReturnGoodsDetails() {
        return tmReturnGoodsDetails;
    }

    public void setTmReturnGoodsDetails(List<TmReturnGoodsDetails> tmReturnGoodsDetails) {
        this.tmReturnGoodsDetails = tmReturnGoodsDetails;
    }

    public List<TmInventoryDetailVoList> getTmInventoryDetailVoList() {
        return tmInventoryDetailVoList;
    }

    public void setTmInventoryDetailVoList(List<TmInventoryDetailVoList> tmInventoryDetailVoList) {
        this.tmInventoryDetailVoList = tmInventoryDetailVoList;
    }

    public List<TmOutTreasuryDetails> getTmOutTreasuryDetails() {
        return tmOutTreasuryDetails;
    }

    public void setTmOutTreasuryDetails(List<TmOutTreasuryDetails> tmOutTreasuryDetails) {
        this.tmOutTreasuryDetails = tmOutTreasuryDetails;
    }

    public List<ReportLossDetails> getReportLossDetails() {
        return reportLossDetails;
    }

    public void setReportLossDetails(List<ReportLossDetails> reportLossDetails) {
        this.reportLossDetails = reportLossDetails;
    }

    public static class TmInventoryVo{
        private String inventoryName;
        private String customerId;
        private Integer status;
        private Integer inventoryType;
        private String id;
        private String inventoryNumber;

        public String getInventoryNumber() {
            return inventoryNumber;
        }

        public void setInventoryNumber(String inventoryNumber) {
            this.inventoryNumber = inventoryNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInventoryName() {
            return inventoryName;
        }

        public void setInventoryName(String inventoryName) {
            this.inventoryName = inventoryName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getInventoryType() {
            return inventoryType;
        }

        public void setInventoryType(Integer inventoryType) {
            this.inventoryType = inventoryType;
        }
    }

    public static class TmInventoryDetailVoList{
        private String productId;
        private String id;
        private String inventoryNumber;
        private String productCode;
        private String productName;
        private String productUnit;
        private Integer numbers;
        private String isScan;
        private Integer isTemp;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

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

        public Integer getNumbers() {
            return numbers;
        }

        public void setNumbers(Integer numbers) {
            this.numbers = numbers;
        }

        public String getIsScan() {
            return isScan;
        }

        public void setIsScan(String isScan) {
            this.isScan = isScan;
        }

        public Integer getIsTemp() {
            return isTemp;
        }

        public void setIsTemp(Integer isTemp) {
            this.isTemp = isTemp;
        }
    }

    public static class TmOutTreasuryDetails{
        private String productId;
        private Integer productNum;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public Integer getProductNum() {
            return productNum;
        }

        public void setProductNum(Integer productNum) {
            this.productNum = productNum;
        }
    }

    public static class TmReturnGoodsDetails{
        private String productId;
        private Integer productNum;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public Integer getProductNum() {
            return productNum;
        }

        public void setProductNum(Integer productNum) {
            this.productNum = productNum;
        }
    }

    public static class ReportLossDetails{
        private String commodityId;
        private Integer quantity;

        public String getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
