package text.bwei.com.recycleritemcolock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import text.bwei.com.recycleritemcolock.Api.Api;
import text.bwei.com.recycleritemcolock.adapter.MyAdapter;
import text.bwei.com.recycleritemcolock.bean.News;
import text.bwei.com.recycleritemcolock.presenter.presenter;
import text.bwei.com.recycleritemcolock.view.Iview;

public class MainActivity extends AppCompatActivity implements Iview {

    private RecyclerView recyclerView;
    private text.bwei.com.recycleritemcolock.presenter.presenter presenter;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new presenter(this);
        presenter.getOk(Api.URL);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void showSuccess(List<News.DataBean> list) {
        myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnClickLisener(new MyAdapter.OnClickLisener() {
            @Override
            public void OnDainji(View v, int position) {
                Intent intent = new Intent(MainActivity.this, Secondactivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "xvbdbvdubvayd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnLong(View v, int position) {

            }
        });


    }

    @Override
    public void showError(String s) {

    }
}
