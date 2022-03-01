package com.example.submission1_made

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission1_made.databinding.ItemRowUsersBinding

class ListUserAdapter(private val listUser:ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(var binding: ItemRowUsersBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup,i : Int): ListViewHolder {
        val binding=ItemRowUsersBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val (name,username,avatar)=listUser[position]
        holder.binding.imgItemPhoto.setImageResource(avatar)
        holder.binding.tvItemName.text=name
        holder.binding.tvItemUsername.text=username
        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])}
    }

    override fun getItemCount(): Int=listUser.size

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

}