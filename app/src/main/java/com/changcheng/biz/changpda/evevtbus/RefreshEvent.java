package com.changcheng.biz.changpda.evevtbus;

public class RefreshEvent {
    private String isRefresh;

    public RefreshEvent(String isRefresh) {
        this.isRefresh = isRefresh;
    }

    public String getRefresh() {
        return isRefresh;
    }

    public void setRefresh(String refresh) {
        isRefresh = refresh;
    }
}
