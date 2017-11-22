package text.bwei.com.greendaos;

import android.app.Application;

import text.bwei.com.greendaos.gen.DaoMaster;
import text.bwei.com.greendaos.gen.DaoSession;
import text.bwei.com.greendaos.gen.UserDao;


/**
 * date：2017/11/22
 * 用途：
 */
public class App extends Application {
    public static UserDao userDao;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "lenvess.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
    }
}
