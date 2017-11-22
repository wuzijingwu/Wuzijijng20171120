package text.bwei.com.wuzijijng20171120;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;
import java.util.Random;

import text.bwei.com.wuzijijng20171120.bean.MyBean;
import text.bwei.com.wuzijijng20171120.presenter.PlayPresenter;
import text.bwei.com.wuzijijng20171120.utils.Api;
import text.bwei.com.wuzijijng20171120.utils.ZoomOutPageTransformer;


public class MainActivity extends AppCompatActivity implements PlayContrast.IView {

//    @BindView(R.id.vp)

//    @BindView(R.id.btn_huan)

    private PlayPresenter playPresenter;
    private ViewPager vp;
    private Button btn_huan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        //http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e539330016&pnum=33
        vp = (ViewPager) findViewById(R.id.vp);
        btn_huan = (Button) findViewById(R.id.btn_huan);

        playPresenter = new PlayPresenter(this);
        playPresenter.LoadData(Api.HOST, Api.catalogId, 1);
        vp.setPageTransformer(true, new ZoomOutPageTransformer());
        btn_huan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPresenter.LoadData(Api.HOST, Api.catalogId, getpage());
            }
        });

    }

    @Override
    public void ShowData(final List<MyBean.RetBean.ListBean> list) {
        //Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                MyBean.RetBean.ListBean lb = list.get(position);
                View v = View.inflate(MainActivity.this, R.layout.item, null);
                ImageView img = (ImageView) v.findViewById(R.id.img);
                TextView title = (TextView) v.findViewById(R.id.tv_title);
                TextView tvt = (TextView) v.findViewById(R.id.tv_text);
                title.setText(lb.getTitle());
                tvt.setText(lb.getDescription());
                ImageLoader.getInstance().displayImage(lb.getPic(), img);
                container.addView(v);
                return v;
            }


            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

    }

    @Override
    public void ShowError(String e) {
        Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        Log.e("及哈哈哈哈哈哈哈哈哈哈哈", e);
    }

//    @OnClick(R.id.btn_huan)
    public void onViewClicked() {

    }

    /* private int getNextPage() {
         if (SystemUtils.isNetworkConnected()) {
             page = StringUtils.getRandomNumber(1, 108);
         }
         return page;
     }
     public static int getRandomNumber(int min, int max) {
         return new Random().nextInt(max) % (max - min + 1) + min;
     }*/
    private int getpage() {

        int max = 108;
        int min = 1;
        Random random = new Random();

        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }
}
