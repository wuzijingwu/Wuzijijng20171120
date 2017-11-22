package text.bwei.com.recycleritemcolock.Api;

import retrofit2.http.GET;
import rx.Observable;
import text.bwei.com.recycleritemcolock.bean.News;

/**
 * Created by dell on 2017/11/22.
 */

public interface ApiService {
    @GET("type/1/p/1")
    Observable<News> getDatas();

}
