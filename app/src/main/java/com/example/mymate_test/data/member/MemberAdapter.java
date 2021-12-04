package com.example.mymate_test.data.member;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymate_test.MateInfoActivity;
import com.example.mymate_test.R;
import com.example.mymate_test.data.member.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
    private List<Member> mData = new ArrayList<>();

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_character;

        TextView txt_nickname,txt_type;

        ViewHolder(@NonNull View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            img_character=itemView.findViewById(R.id.img_character);
            txt_nickname=itemView.findViewById(R.id.txt_nickname);
            txt_type=itemView.findViewById(R.id.txt_type);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent=new Intent(view.getContext(), MateInfoActivity.class);

                    intent.putExtra("memberId",mData.get(getAdapterPosition()).getId());
                    view.getContext().startActivity(intent);


                }
            });
        }

        void onBind(Member item){
            if(item.getMateType2().equals("소무니")){
                img_character.setImageResource(R.drawable.character3);
            } else if(item.getMateType2().equals("테크")){
                img_character.setImageResource(R.drawable.character4);
            }else if(item.getMateType2().equals("밥")){
                img_character.setImageResource(R.drawable.character1);
            }else{
                img_character.setImageResource(R.drawable.character2);
            }
            txt_nickname.setText(item.getNickname());
            String str=item.getMateType1()+item.getMateType2();
            txt_type.setText(str);
        }

    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_member, parent, false) ;

        return new MemberAdapter.ViewHolder(view) ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(MemberAdapter.ViewHolder holder, int position) {
        holder.onBind(mData.get(position));
    }

    public void setMemberList(List<Member> list){
        this.mData=list;
        notifyDataSetChanged();
    }


    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    public void addItem(Member item){
        mData.add(item);
    }

}
