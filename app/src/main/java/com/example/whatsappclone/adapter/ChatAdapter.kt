package com.example.whatsappclone.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsappclone.R
import com.example.whatsappclone.activity.ChatActivity
import com.example.whatsappclone.databinding.ChatUserItemLayoutBinding
import com.example.whatsappclone.model.UserModel

class ChatAdapter(val context : Context, val list : ArrayList<UserModel>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>(){






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {

        return ChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_user_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
             var user = list[position]
        Glide.with(context).load(user.imgUrl).into(holder.userImage)
        holder.userName.text = user.name

        holder.itemView.setOnClickListener{
            val intent = Intent(context,ChatActivity::class.java)
            intent.putExtra("uid",user.uid)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
    return list.size
    }



    class ChatViewHolder(view : View):RecyclerView.ViewHolder(view) {
       // var binding : ChatUserItemLayoutBinding = ChatUserItemLayoutBinding.bind(view)

        var userName = view.findViewById<TextView>(R.id.userName)
        var userImage = view.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.userImage)

    }

}