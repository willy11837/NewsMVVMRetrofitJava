package com.android.mvvmretrofitjava.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.mvvmretrofitjava.R;
import com.android.mvvmretrofitjava.model.NewsModel.NewsBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.lang.reflect.GenericArrayType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {
    private Context context;
    private NewsBean mNewsBean;
    private ItemClickListener clickListener;

    public NewsListAdapter(Context context, NewsBean newsBean, ItemClickListener clickListener) {
        this.context = context;
        this.mNewsBean = newsBean;
        this.clickListener = clickListener;
    }

    public void setDataList(NewsBean newsBean) {
        this.mNewsBean = newsBean;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public NewsListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListAdapter.MyViewHolder holder, int position) {
        List<NewsBean.GetVectorDTO.ItemsDTOX> dataList = this.mNewsBean.getGetVector().getItems();

        if (dataList.get(position) != null) {
            // 取得時間
            if (dataList.get(position).getExtra() != null) {
              if (dataList.get(position).getExtra().getCreated() != 0) {
                  Date date = new Date(dataList.get(position).getExtra().getCreated());
                  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.TAIWAN);
                  holder.created.setText(simpleDateFormat.format(date));
              }else {
                  holder.created.setVisibility(View.GONE);
              }
            }

            if (dataList.get(position).getAppearance() != null) {
                // 取得截圖
                if (dataList.get(position).getAppearance().getThumbnail() != null
                        && !dataList.get(position).getAppearance().getThumbnail().isEmpty()) {

                    Glide.with(context)
                            .load(dataList.get(position).getAppearance().getThumbnail())
                            .apply(RequestOptions.centerCropTransform())
                            .error(R.drawable.ic_launcher_background)
                            .into(holder.imageView);

                    if (dataList.get(position).getAppearance().getThumbnail().contains("id=OVFT")) {
                        setVisibility(false, holder.clItem);
                    }

                } else if (dataList.get(position).getAppearance().getThumbnail() == null
                        && dataList.get(position).getTitle() == null) {
                    setVisibility(false, holder.clItem);
                } else {
                    holder.imageView.setVisibility(View.GONE);
                    holder.llContent.setVisibility(View.GONE);
                }

                // 取得網址
                if (dataList.get(position).getAppearance().getSubscript() != null
                        && !dataList.get(position).getAppearance().getSubscript().isEmpty()) {
                   holder.subscript.setText(dataList.get(position).getAppearance().getSubscript());
                }

                // 取得mainTitle
                if (dataList.get(position).getAppearance().getMainTitle() != null
                        && !dataList.get(position).getAppearance().getMainTitle().isEmpty()) {
                    holder.mainTitle.setText(dataList.get(position).getAppearance().getMainTitle());
                } else {
                    holder.mainTitle.setVisibility(View.GONE);
                }

                // 取得subTitle
                if (dataList.get(position).getAppearance().getSubTitle() != null
                        && !dataList.get(position).getAppearance().getSubTitle().isEmpty()) {
                    holder.subtitle.setText(dataList.get(position).getAppearance().getSubTitle());
                } else {
                    holder.subtitle.setVisibility(View.GONE);
                }

            } else if (dataList.get(position).getAppearance() == null
            && dataList.get(position).getTitle() == null) {
                setVisibility(false, holder.clItem);
            }

            // 取得新聞分類
            if (dataList.get(position).getTitle() != null) {
                holder.tvTitle.setText(dataList.get(position).getTitle());
                holder.imageView.setVisibility(View.GONE);
                holder.llContent.setVisibility(View.GONE);
            } else {
                holder.tvTitle.setVisibility(View.GONE);
            }
        }

        holder.itemView.setOnClickListener(view ->
                clickListener.onNewsClick(position));
    }

    //防止隐藏item出现空白
    public void setVisibility(boolean isVisible, View itemView) {
        RecyclerView.LayoutParams param = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        if (isVisible) {
            param.height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
            param.width = ConstraintLayout.LayoutParams.MATCH_PARENT;
            itemView.setVisibility(View.VISIBLE);
        } else {
            itemView.setVisibility(View.GONE);
            param.height = 0;
            param.width = 0;
        }
        itemView.setLayoutParams(param);
    }

    @Override
    public int getItemCount() {
        return mNewsBean == null ? 0 : mNewsBean.getGetVector().getItems().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView subscript;
        TextView created;
        TextView mainTitle;
        TextView subtitle;
        ImageView imageView;
        ConstraintLayout clItem;
        LinearLayout llContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
            subscript = itemView.findViewById(R.id.subscript);
            created = itemView.findViewById(R.id.created);
            mainTitle = itemView.findViewById(R.id.main_title);
            subtitle = itemView.findViewById(R.id.subtitle);
            imageView = itemView.findViewById(R.id.thumbnail);
            clItem = itemView.findViewById(R.id.cl_item);
            llContent = itemView.findViewById(R.id.ll_content);
        }
    }

    public interface ItemClickListener{
        void onNewsClick(int position);
    }
}
