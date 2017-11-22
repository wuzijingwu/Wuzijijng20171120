package text.bwei.com.wuzijijng20171120.model;

/**
 * Created by dell on 2017/11/20.
 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.wuzijijng20171120.PlayContrast;
import text.bwei.com.wuzijijng20171120.bean.MyBean;
import text.bwei.com.wuzijijng20171120.utils.ApiService;

/**
 * Created by Zhang on 2017/11/20.
 */

public class PlayModel implements PlayContrast.IModel {
    @Override
    public void RequestData(String url, String catalogId, int pnum, final PlayContrast.OnPlayListener onPlayListener) {

        final Map<String, String> map = new HashMap<>();
        map.put("catalogId",catalogId);
        map.put("pnum",pnum+"");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Observable<MyBean> datas = apiService.getDatas("columns/getVideoList.do", map);
        datas.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onPlayListener.OnError(e.getMessage().toString());
                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        List<MyBean.RetBean.ListBean> list = myBean.getRet().getList();
                        onPlayListener.OnSuccess(list);
                    }
                });
    }
}