package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databinding.CardItemUserViewHolderBinding
import com.example.roomdatabase.room.User

class UserAdapetr:RecyclerView.Adapter<UserAdapetr.UserViewHolder>() {
    lateinit var binding:CardItemUserViewHolderBinding
    private var list= mutableListOf<User>()







    class UserViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){






    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
val inflater=LayoutInflater.from(parent.context)
        binding= CardItemUserViewHolderBinding.inflate(inflater,parent,false)
        return UserViewHolder(binding.root)
    }

    override fun getItemCount()=list.size

    fun setData(data:List<User>){
        list.apply {
            clear()
            addAll(data)
        }
    }



    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
      val user=list[position]
        binding.txtFirstName.text=user.fitstName
        binding.txtLastName.text=user.lastName


           }
}