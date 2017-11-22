package text.bwei.com.recycleritemcolock.model;

import java.util.List;

import text.bwei.com.recycleritemcolock.bean.News;

/**
 * Created by dell on 2017/11/22.
 */

public interface Onselectclock {
    void dataSuccess(List<News.DataBean> list);
    void dataError(String s);

}
