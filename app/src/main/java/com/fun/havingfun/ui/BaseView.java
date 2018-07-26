package com.fun.havingfun.ui;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}