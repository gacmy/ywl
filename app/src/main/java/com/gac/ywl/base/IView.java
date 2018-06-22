package com.gac.ywl.base;


/**
 * @title IView.java
 * @package com.gac.footprint.base.base
 * @description  {}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public interface IView {
    public void showNetError();
    public void showNoData();
    public void showContent();
    public void showNetError(String msg);
    public void showNoData(String msg);
}
