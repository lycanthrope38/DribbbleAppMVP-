package com.thongle.dribbbleapp.view.comment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thongle.dribbbleapp.R;
import com.thongle.dribbbleapp.config.Constant;
import com.thongle.dribbbleapp.data.remote.model.Shot;
import com.thongle.dribbbleapp.data.remote.model.comment.Comment;
import com.thongle.dribbbleapp.util.GlideUtils;

import org.parceler.Parcels;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ThongLe on 6/18/2016.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {


    private Context mContext;
    private List<Comment> mCommentList;

    public CommentAdapter(Context context, List<Comment> comments) {
        this.mContext = context;
        this.mCommentList = comments;
    }

    public void setItems(List<Comment> comments) {
        this.mCommentList.addAll(comments);
        notifyDataSetChanged();
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentHolder(LayoutInflater.from(mContext).inflate(R.layout.comment_row, parent, false));
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        Comment comment = mCommentList.get(position);
        holder.setupData(comment);
    }

    @Override
    public int getItemCount() {
        return mCommentList.size();
    }

    class CommentHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.player_avatar)
        ImageView playerAvatar;
        @Bind(R.id.player_name)
        TextView playerName;
        @Bind(R.id.comment_body)
        TextView commentBody;

        public CommentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setupData(Comment comment) {
            GlideUtils.display(playerAvatar, comment.getUser().getAvatarUrl());
            playerName.setText(comment.getUser().getName());
            commentBody.setText(Html.fromHtml(comment.getBody()));
        }
    }

}
