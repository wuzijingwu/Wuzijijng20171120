package text.bwei.com.recycleritemcolock.presenter;

import java.util.List;

import text.bwei.com.recycleritemcolock.bean.News;
import text.bwei.com.recycleritemcolock.model.Imodel;
import text.bwei.com.recycleritemcolock.model.Onselectclock;
import text.bwei.com.recycleritemcolock.model.model;
import text.bwei.com.recycleritemcolock.view.Iview;

/**
 * Created by dell on 2017/11/22.
 */

public class presenter {
    Imodel imodel;
    Iview iview;

    public presenter(Iview iview) {
        this.iview = iview;
        imodel=new model();
    }

    public void getOk(String url){
        imodel.RequsetSuccess(url, new Onselectclock() {
            @Override
            public void dataSuccess(List<News.DataBean> list) {
                iview.showSuccess(list);

            }

            @Override
            public void dataError(String s) {



            }
        });


    }

}
