package com.gac.ywl.component;

import java.util.List;

/**
 * @title IRefreshLoadMore.java
 * @package com.gac.footprint.base.component
 * @description  {刷新加载接口}
 * @author gacmy
 * @date 2018/6/16 0016
 *
 */
public interface IRefreshLoadMore<T> {
    public void setRefreshData(List<T> data);
    public void setLoadMoreData(List<T> data);
}
