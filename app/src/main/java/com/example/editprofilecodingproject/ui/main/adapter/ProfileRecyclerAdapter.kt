package com.example.editprofilecodingproject.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.data.model.ProfileInfo
import kotlinx.android.synthetic.main.layout_profile_image.view.*
import kotlinx.android.synthetic.main.layout_profileinfo_list_item.view.*


//class ProfileRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    private var items: List<ProfileInfo> = ArrayList()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        Log.i("VIEW_TYPE", viewType.toString())
//        when (viewType) {
//            1 -> {
//                return ProfileInfoViewHolder(
//                    LayoutInflater.from(parent.context)
//                        .inflate(R.layout.layout_profileinfo_list_item, parent, false)
//                )
//            }
//            else -> {
//                return PhotoViewHolder(
//                    LayoutInflater.from(parent.context)
//                        .inflate(R.layout.layout_profile_image, parent, false)
//                )
//            }
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (holder.itemViewType) {
//            1 -> {
//                (holder as ProfileInfoViewHolder).bind(items.get(position))
//            }
//            else -> {
//                (holder as PhotoViewHolder).bind(items.get(position))
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    fun submitList(list: List<ProfileInfo>) {
//        items = list
//    }
//
//    class ProfileInfoViewHolder
//    constructor(
//        itemView: View
//    ) : RecyclerView.ViewHolder(itemView) {
//
//        val info_name = itemView.name
//        val info_description = itemView.description
//
//        fun bind(profileInfo: ProfileInfo) {
//            info_name.setText(profileInfo.name)
//            info_description.setText(profileInfo.description)
//        }
//    }
//
//
//    class PhotoViewHolder
//    constructor(
//        itemView: View
//    ) : RecyclerView.ViewHolder(itemView) {
//
//        val photo = itemView.profile_picture
//
//        fun bind(profileInfo: ProfileInfo) {
//
//            val requestOptions = RequestOptions()
//                    .placeholder(R.drawable.ic_launcher_background)
//                    .error(R.drawable.ic_launcher_background)
//                    .circleCrop()
//
//
//            Glide.with(itemView.context)
//                    .applyDefaultRequestOptions(requestOptions)
//                    .load(profileInfo.description)
//                    .into(photo)
//
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        if (position > 0) {
//            return 1
//        } else {
//            return 0
//        }
//    }
//
//}



class MainAdapter(
    private val profileData: ArrayList<ProfileInfo>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(profileInfo: ProfileInfo) {
            itemView.name.text = profileInfo.name
            itemView.description.text = profileInfo.description
            Glide.with(itemView.profile_picture.context)
                .load(profileInfo.description)
                .into(itemView.profile_picture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_profileinfo_list_item, parent,
                false
            )
        )

    override fun getItemCount(): Int = profileData.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(profileData[position])

    fun addData(list: List<ProfileInfo>) {
        profileData.addAll(list)
    }
}
