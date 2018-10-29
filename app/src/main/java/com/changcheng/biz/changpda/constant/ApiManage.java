package com.changcheng.biz.changpda.constant;

public class ApiManage {
    public static final String baseUrl = "http://106.37.75.193:8910/";//正式
//    public static final String baseUrl = "http://125.64.5.82:8081/eisp/";//测试
    //    public static final String baseUrl = "http://192.168.10.95:8080/";//233,95本地
    public static final String outTreasury = "restOutTreasuryController.do?";//出库
    public static final String restTmInventory = "restTmInventoryController.do?";//盘点
    public static final String returnGoods = "restReturnGoodsController.do?";//退货
    public static final String receipt = "restWarehouseReceipt.do?";//入库
    public static final String reportLoss = "restTmReportLossController.do?";//报损
    public static final String barcode = "restBarcodeCorrectLog.do?";//二维码纠正
    /**
     * 出库
     */
    //查询出库订单列表
    public static String getOutStorageList(){
        return baseUrl+outTreasury+"findTmOutTreasuryDatagridList";
    }
    //查询经销商相关门店
    public static String getUserTerminal(){
        return baseUrl+outTreasury+"findUserTerminal";
    }
    //查询商品/
    public static String getNotOutTreasuryList(){
        return baseUrl+outTreasury+"findTmBaseProductNotOutTreasuryList";
    }
    //提交一个新的出库单或者出库一个未出库
    public static String getdoOut(){
        return baseUrl+outTreasury+"doOut";
    }
    //查询订单明细
    public static String getOutTreasuryDetails(){
        return baseUrl+outTreasury+"findOutTreasuryDetails";
    }
    //扫码doScanrestOutTreasuryController
    public static String getOutTreasuryScan(){
        return baseUrl+outTreasury+"doScan";
    }

    //登录接口
    public static String getLogin(){
        return baseUrl+"restLoginController.do?login";
    }

    /**
     * 盘点
     */
    //用于展示盘点单列表信息
    public static String getTmInventoryList(){
        return baseUrl+restTmInventory+"findTmInventoryList";
    }
    //通过盘点单id获取盘点单明细
    public static String getTmInventoryDetail(){
        return baseUrl+restTmInventory+"findTmInventoryDetailList";
    }
    //分页获取产品基础表findTmBaseProductList
    public static String getIntoryProductList(){
        return baseUrl+restTmInventory+"findTmBaseProductList";
    }
    //提交基础产品到明细（单盘下一步）restTmInventoryController.do? addProductInventoryToDetail
    public static String getAddProductDetail(){
        return baseUrl+restTmInventory+"addBaseProductToDetail";
    }
    //单盘完成（提交按钮）restTmInventoryController.do? addTemporaryInventoryToDetail
    public static String getSubmitSingle(){
        return baseUrl+restTmInventory+"addTemporaryInventoryToDetail";
    }
    //全完成（提交按钮）
    public static String getSubmitAll(){
        return baseUrl+restTmInventory+"addProductInventoryToDetail";
    }
    //扫码doScan
    public static String getInventoryScan(){
        return baseUrl+restTmInventory+"doScan";
    }

    /**
     * 退货
     */
    //1.用于查询退货订单列表
    public static String getReturnGoodsList(){
        return baseUrl+returnGoods+"findTmReturnGoodsDatagridList";
    }
    //2.查询商品
    public static String getReturnProductList(){
        return baseUrl+returnGoods+"findTmBaseProductNotReturnGoodsGoodsList";
    }

    //提交一个新的出库单或者出库一个未出库
    public static String getReturnDoOut(){
        return baseUrl+returnGoods+"doOut";
    }//findReturnGoodsDetails

    //3.查询订单明细
    public static String getReturnGoodsDetail(){
        return baseUrl+returnGoods+"findReturnGoodsDetails";
    }
    //扫码doScan
    public static String getReturnScan(){
        return baseUrl+returnGoods+"doScan";
    }

    /**
     * 入库
     */
    //入库交货单数据
    public static String getDataByParames(){
        return baseUrl+receipt+"findDataByParames";
    }
    //入库交货单明细数据collectGoods
    public static String getDataItemAll(){
        return baseUrl+receipt+"findDataItemAll";
    }

    //入库单收货接口
    public static String getCollectGoods(){
        return baseUrl+receipt+"collectGoods";
    }

    /**
     * 报损
     */
    //出库单报损列表
    public static String getReportLossList(){
        return baseUrl+reportLoss+"findReportLossList";
    }
    //2.查询商品
    public static String getLossProductList(){
        return baseUrl+reportLoss+"findTmBaseProductList";
    }
    //提交报损一条订单findTmReportLossCommodityDetailsList
    public static String getSubmitLoss(){
        return baseUrl+reportLoss+"sumbitReportLoss";
    }
    public static String getFindLossDetail(){
        return baseUrl+reportLoss+"findTmReportLossCommodityDetailsList";
    }
    //扫码doScan
    public static String getLossScan(){
        return baseUrl+reportLoss+"doScan";
    }

    /**
     * 二维码纠正
     */
    public static String getScanProducts(){
        return baseUrl+barcode+"getProducts";
    }
    //
    public static String getUpdateBarode(){
        return baseUrl+barcode+"updateBarodeProductInfo";
    }


    //
    public static String getProduct(){
        return baseUrl+"restQrInfoController.do?getProduct";
    }


}
