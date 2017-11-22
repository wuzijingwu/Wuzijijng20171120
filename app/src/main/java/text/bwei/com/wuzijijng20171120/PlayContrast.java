package text.bwei.com.wuzijijng20171120;


import java.util.List;

import text.bwei.com.wuzijijng20171120.bean.MyBean;


public interface PlayContrast {
    interface IView{
        void ShowData(List<MyBean.RetBean.ListBean> list);
        void ShowError(String e);
    }
    interface IModel{
        void RequestData(String url,String catalogId,int pnum,OnPlayListener onPlayListener);
    }
    interface OnPlayListener{
        void OnSuccess(List<MyBean.RetBean.ListBean> list);
        void OnError(String e);
    }
    interface IPresenter{
        void LoadData(String url,String catalogId,int pnum);
    }
}