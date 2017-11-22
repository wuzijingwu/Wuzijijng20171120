package com.bwie.test.greendaodemolianxi;

import android.app.Application;

import com.bwie.test.greendaodemolianxi.gen.DaoMaster;
import com.bwie.test.greendaodemolianxi.gen.DaoSession;
import com.bwie.test.greendaodemolianxi.gen.UserDao;

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
