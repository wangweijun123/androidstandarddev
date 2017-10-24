package com.wangweijun.standarddevelop.appmodule.home;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wangweijun.standarddevelop.R;
import com.wangweijun.standarddevelop.io.network.LeHttpApi;
import com.wangweijun.standarddevelop.model.IResponse;
import com.wangweijun.standarddevelop.model.RankListModel;
import com.wangweijun.standarddevelop.model.RecommendModel.RankRecommedModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    ImageView iv;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LeHttpApi.listRepos();

        iv = (ImageView)findViewById(R.id.iv);
        listView  = (ListView)findViewById(R.id.lv);

        Glide.with(getApplicationContext())
                .load("http://i1.letvimg.com//lc05_iptv//201709//19//17//20//tmp3e3e95cf-3bf4-46c1-a36a-95ca33010891256.png")
                .into(iv);

        Callback<IResponse<RankListModel>> callback = new Callback<IResponse<RankListModel>>() {
            @Override
            public void onResponse(Call<IResponse<RankListModel>> call, Response<IResponse<RankListModel>> response) {
                IResponse<RankListModel> model = response.body();
                RankListModel rankListModel = model.getEntity();
                Log.i(LeHttpApi.TAG, response.headers().toString());
                Log.i(LeHttpApi.TAG,  response.code()+", "+response.message());
                List<RankRecommedModel> list = rankListModel.ranklist.get(0).items;
                for(RankRecommedModel model1 : list) {
                    Log.i(LeHttpApi.TAG, model1.toString());
                }
                listView.setAdapter(new Mydapter(list));
            }

            @Override
            public void onFailure(Call<IResponse<RankListModel>> call, Throwable t) {
                t.printStackTrace();
                Log.i(LeHttpApi.TAG, "onFailure status");
            }
        };
        LeHttpApi.doGetAsync(callback);
    }

    class Mydapter extends BaseAdapter {
        List<RankRecommedModel> list;

        Mydapter(List<RankRecommedModel> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext())
                        .inflate(R.layout.flickr_photo_list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.photo_view = (ImageView)convertView.findViewById(R.id.photo_view);
                viewHolder.title_view = (TextView)convertView.findViewById(R.id.title_view);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder)convertView.getTag();
            }

            setValue(viewHolder, list.get(i));
            return convertView;
        }
    }

    private void setValue(ViewHolder viewHolder, RankRecommedModel model) {
        viewHolder.title_view.setText(model.name);
        Glide.with(getApplicationContext()).load(model.icon.url)
                .into(viewHolder.photo_view);
    }

    class ViewHolder {
        ImageView photo_view;
        TextView title_view;
    }
}
