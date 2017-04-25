package sparakis.com.ksparakisresume.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import sparakis.com.ksparakisresume.R;
import sparakis.com.ksparakisresume.database.Comments;
import java.util.List;
import sparakis.com.ksparakisresume.viewholders.CommentsViewHolder;

/**
 * Created by ksparakis on 4/12/16.
 */


public class CommentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Comments> mItemList;
    public CommentsAdapter(List<Comments> itemList) {
        mItemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.comment_cell, parent, false);
        return CommentsViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        CommentsViewHolder holder = (CommentsViewHolder) viewHolder;
        Comments comment = mItemList.get(position);

        holder.setNameText(comment.name);
        holder.setCompanyText(comment.company);
        holder.setDateText(comment.date);
        holder.setCommenText(comment.comment);

    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

}