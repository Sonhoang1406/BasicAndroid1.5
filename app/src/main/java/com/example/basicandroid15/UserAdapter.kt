package com.example.basicandroid15

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: ArrayList<UserItem>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
            return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:UserViewHolder, position: Int) {
            val currentUser = userList[position]
        holder.nameTextView.text = currentUser.name
        holder.ageTextView.text = currentUser.age.toString()
        holder.sexTextView.text = currentUser.sex
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val nameTextView: TextView = itemView.findViewById(R.id.tvName)
            val ageTextView: TextView = itemView.findViewById(R.id.tvAge)
            val sexTextView: TextView = itemView.findViewById(R.id.tvSex)
    }
}