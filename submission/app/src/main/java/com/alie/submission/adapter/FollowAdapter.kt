package com.alie.submission.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alie.submission.R
import com.alie.submission.model.User
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FollowAdapter internal constructor(
    private val context: Context
): RecyclerView.Adapter<FollowAdapter.FollowerHolder>(){

    private var listFollow : List<User> = ArrayList()
    fun setDataFollow(listFollow : List<User>) {
        this.listFollow = listFollow
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_follow,parent,false)
        return FollowerHolder(view)
    }

    override fun getItemCount(): Int = listFollow.size


    override fun onBindViewHolder(holder: FollowerHolder, position: Int) {
        holder.bind(listFollow[position])
    }

    inner class FollowerHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        private val tvUsernameFollow = itemView.findViewById<TextView>(R.id.tvUsernameFollow)
        private val imgFollow = itemView.findViewById<ImageView>(R.id.imageListFollow)

        fun bind(detailUser: User){
            tvUsernameFollow.text = detailUser.name
            Glide.with(context)
                .load(detailUser.avatarUrl)
                .apply(RequestOptions().override(100,100))
                .into(imgFollow)
        }
    }
}