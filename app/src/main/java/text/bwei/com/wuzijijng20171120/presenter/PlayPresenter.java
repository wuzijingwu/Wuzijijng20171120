package text.bwei.com.wuzijijng20171120.presenter;

/**
 * Created by dell on 2017/11/20.
 */


import java.util.List;

import text.bwei.com.wuzijijng20171120.PlayContrast;
import text.bwei.com.wuzijijng20171120.bean.MyBean;
import text.bwei.com.wuzijijng20171120.model.PlayModel;


public class PlayPresenter implements PlayContrast.IPresenter {
    PlayContrast.IView iView;
    PlayContrast.IModel iModel;

    public PlayPresenter(PlayContrast.IView iView) {
        this.iView = iView;
        iModel = new PlayModel();
    }

    @Override
    public void LoadData(String url, String catalogId, int pnum) {
        iModel.RequestData(url, catalogId, pnum, new PlayContrast.OnPlayListener() {
            @Override
            public void OnSuccess(List<MyBean.RetBean.ListBean> list) {
                iView.ShowData(list);
            }

            @Override
            public void OnError(String e) {
                iView.ShowError(e);
            }
        });
    }
}
