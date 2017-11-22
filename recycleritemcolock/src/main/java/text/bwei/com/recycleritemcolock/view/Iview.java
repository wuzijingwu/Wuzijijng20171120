package text.bwei.com.recycleritemcolock.view;

import java.util.List;

import text.bwei.com.recycleritemcolock.bean.News;

/**
 * Created by dell on 2017/11/22.
 */

public interface Iview {
    void showSuccess(List<News.DataBean> list);
    void showError(String s);
}

