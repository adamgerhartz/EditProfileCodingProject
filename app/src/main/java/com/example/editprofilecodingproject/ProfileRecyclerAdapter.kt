package com.example.editprofilecodingproject

import android.graphics.drawable.Drawable
import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.editprofilecodingproject.models.ProfileInfo
import kotlinx.android.synthetic.main.layout_profile_image.view.*
import kotlinx.android.synthetic.main.layout_profileinfo_list_item.view.*

class ProfileRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<ProfileInfo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.i("VIEW_TYPE", viewType.toString())
        when (viewType) {
            1 -> {
                return ProfileInfoViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_profileinfo_list_item, parent, false)
                )
            }
            else -> {
                return PhotoViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_profile_image, parent, false)
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            1 -> {
                (holder as ProfileInfoViewHolder).bind(items.get(position))
            }
            else -> {
                (holder as PhotoViewHolder).bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(list: List<ProfileInfo>) {
        items = list
    }

    class ProfileInfoViewHolder
    constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val info_name = itemView.name
        val info_description = itemView.description

        fun bind(profileInfo: ProfileInfo) {
            info_name.setText(profileInfo.name)
            info_description.setText(profileInfo.description)
        }
    }


    class PhotoViewHolder
    constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val headerText = itemView.edit_profile
        val photoFile = itemView.profile_picture

        fun bind(profileInfo: ProfileInfo) {
            headerText.setText(profileInfo.headerTextEditProfile)
            photoFile.setImageResource(R.drawable.profile_pic)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position > 0) {
            return 1
        } else {
            return 0
        }
    }

}
