package com.example.feed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.R
import com.example.feed.models.Post
import de.hdodenhof.circleimageview.CircleImageView

class PostAdapter: RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    var postList: MutableList<Post> = mutableListOf()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profilePicCv: CircleImageView = itemView.findViewById(R.id.profile_pic)
        val nameTv: TextView = itemView.findViewById(R.id.name_tv)
        val designationTv: TextView = itemView.findViewById(R.id.designation_tv)
        val postTv: TextView = itemView.findViewById(R.id.post_tv)
        val postImageIv: ImageView = itemView.findViewById(R.id.post_img)

        fun bind(post: Post, position: Int) {
            nameTv.text = post.userName
            designationTv.text = post.designation
            postTv.text = post.post

            if (position % 3 == 0) {
                postImageIv.visibility = View.VISIBLE
            } else {
                postImageIv.visibility = View.GONE
            }
//            if (!post.url.isEmpty()) {
//
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_post, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(postList[position], position)
    }

    override fun getItemCount(): Int = postList.size

    fun refreshData(postList: List<Post>) {
        if (this.postList.size != 0) {
            this.postList.clear()
        }
        this.postList.addAll(postList)
        notifyDataSetChanged()
    }
}