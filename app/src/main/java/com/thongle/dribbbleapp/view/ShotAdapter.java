package com.thongle.dribbbleapp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thongle.dribbbleapp.R;
import com.thongle.dribbbleapp.config.Constant;
import com.thongle.dribbbleapp.data.remote.model.Shot;
import com.thongle.dribbbleapp.util.GlideUtils;
import com.thongle.dribbbleapp.view.comment.ShotIdActivity;

import org.parceler.Parcels;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ThongLe on 5/3/2016.
 */
public class ShotAdapter extends RecyclerView.Adapter<ShotAdapter.ShotHodel> {

    private Context mContext;
    private List<Shot> mShotList;

    public ShotAdapter(Context context, List<Shot> shots) {
        this.mContext = context;
        this.mShotList = shots;
    }

    @Override
    public ShotHodel onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShotHodel(LayoutInflater.from(mContext).inflate(R.layout.shot_view_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ShotHodel holder, int position) {
        Shot shot = mShotList.get(position);
        holder.setupData(shot);
    }


    @Override
    public int getItemCount() {
        return mShotList.size();
    }

    public void setItems(List<Shot> shots) {
        this.mShotList.addAll(shots);
        notifyDataSetChanged();
    }


    class ShotHodel extends RecyclerView.ViewHolder {

        @Bind(R.id.shot_image)
        ImageView shotImage;
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.user)
        TextView user;
        @Bind(R.id.views)
        TextView views;
        @Bind(R.id.likes)
        TextView likes;
        @Bind(R.id.comments)
        TextView comments;
        @Bind(R.id.time)
        TextView time;

        public ShotHodel(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setupData(Shot shot) {
            GlideUtils.display(shotImage, shot.getImages().getNormal());
            title.setText(shot.getTitle());
            user.setText(shot.getUser().getName());
            views.setText(String.valueOf(shot.getViewsCount()));
            likes.setText(String.valueOf(shot.getLikesCount()));
            comments.setText(String.valueOf(shot.getCommentsCount()));
            time.setText(String.valueOf(shot.getCreatedAt()));

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, ShotIdActivity.class);
                intent.putExtra(Constant.SHOT_ID, Parcels.wrap(shot));
                mContext.startActivity(intent);
            });
        }
    }
}
