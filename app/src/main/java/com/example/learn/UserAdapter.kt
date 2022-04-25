package com.example.learn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learn.databinding.UserInfoBinding
import com.google.firebase.auth.UserInfo

class UserAdapter (val context: Context , val userList : ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(val itemBinding: UserInfoBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

            fun bindItem(user: User){
                itemBinding.textUsername.text = user.name_
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(UserInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentuser = userList[position]
        holder.bindItem(currentuser)
    }

    override fun getItemCount(): Int {
       return userList.size
    }

}


