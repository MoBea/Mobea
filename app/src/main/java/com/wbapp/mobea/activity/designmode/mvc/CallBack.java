package com.wbapp.mobea.activity.designmode.mvc;

public interface CallBack {
    /**
     * @param resultCode 请求结果返回的标识码
     * @param bitmap     Model层数据中Bitmap对象，用户Control刷新View
     */
    void callback(int resultCode, ImageBean bitmap);
}
