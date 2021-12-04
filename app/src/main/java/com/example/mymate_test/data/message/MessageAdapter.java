package com.example.mymate_test.data.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymate_test.R;
import com.example.mymate_test.data.message.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<Message> mData = new ArrayList<>();

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_sender,txt_context ;

        ViewHolder(@NonNull View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            txt_sender = itemView.findViewById(R.id.txt_sender) ;
            txt_context=itemView.findViewById(R.id.txt_context);
        }

        void onBind(Message item){
            txt_sender.setText(item.getNickname());
            txt_context.setText(item.getContext());
        }

    }


    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false) ;

        return new ViewHolder(view) ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(MessageAdapter.ViewHolder holder, int position) {
        holder.onBind(mData.get(position));
    }

    public void setMessageList(List<Message> list){
        this.mData=list;
        notifyDataSetChanged();
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    public void addItem(Message item){
        mData.add(item);
    }

    public void setItem(int position,Message item){
        mData.set(position,item);
    }

}
