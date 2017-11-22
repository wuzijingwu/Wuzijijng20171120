package text.bwei.com.recycleritemcolock.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.recycleritemcolock.Api.ApiService;
import text.bwei.com.recycleritemcolock.bean.News;

/**
 * Created by dell on 2017/11/22.
 */

public class model implements Imodel {


    @Override
    public void RequsetSuccess(String url, final Onselectclock onselectclock) {
        //创建Retrofit
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(okHttpClient)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        //结合rxjava
        Observable<News> datas = apiService.getDatas();
        datas.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<MyBean>() {
                .subscribe(new Subscriber<News>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(News news) {
                        List<News.DataBean> data = news.getData();
                        onselectclock.dataSuccess(data);

                    }
                });

    }
}
