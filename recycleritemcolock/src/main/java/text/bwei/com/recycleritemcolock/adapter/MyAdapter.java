package text.bwei.com.recycleritemcolock.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import text.bwei.com.recycleritemcolock.R;
import text.bwei.com.recycleritemcolock.bean.News;

/**
 * Created by dell on 2017/11/22.
 */

public class MyAdapter extends RecyclerView.Adapter {

    List<News.DataBean> list;
    private MyViewHolder myViewHolder;
    private OnClickLisener onClickLisener;

    public OnClickLisener getOnClickLisener() {
        return onClickLisener;
    }

    public void setOnClickLisener(OnClickLisener onClickLisener) {
        this.onClickLisener = onClickLisener;
    }
    public interface OnClickLisener {
        void OnDainji(View v, int position);

        void OnLong(View v, int position);
    }


    public MyAdapter(List<News.DataBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText(list.get(position).getNews_title());
        myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              onClickLisener.OnDainji(view,position);
            }
        });

        myViewHolder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onClickLisener.OnLong(view,position);
                return true;
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView textView;
        private final ImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }




}
