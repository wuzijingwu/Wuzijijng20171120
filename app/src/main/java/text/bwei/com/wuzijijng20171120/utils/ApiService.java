package text.bwei.com.wuzijijng20171120.utils;

/**
 * Created by dell on 2017/11/20.
 */

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import text.bwei.com.wuzijijng20171120.bean.MyBean;


public interface ApiService {

    @POST
    Observable<MyBean> getDatas(@Url String url, @QueryMap Map<String,String> map);
}