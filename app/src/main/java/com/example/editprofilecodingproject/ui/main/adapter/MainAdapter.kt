package com.example.editprofilecodingproject.ui.main.adapter

import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.media.AudioManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.editprofilecodingproject.R
import com.example.editprofilecodingproject.data.model.ProfileInfo
import kotlinx.android.synthetic.main.layout_profile_image.view.*
import kotlinx.android.synthetic.main.layout_profileinfo_list_item.view.*


class MainAdapter(
        private val profileData: ArrayList<ProfileInfo>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    private var mItemViewType: Int = 0
    var onItemClick: ((ProfileInfo) -> Unit)? = null
    private lateinit var cardView: CardView

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(profileInfo: ProfileInfo) {
            if (itemViewType == 1) {
                itemView.name.text = profileInfo.name
                itemView.description.text = profileInfo.description
            } else {
                Glide.with(itemView.profile_picture.context)
                    .load(profileInfo.description)
                    .into(itemView.profile_picture)
            }
        }
        fun getCardView(): CardView? {
            return itemView.face_background
        }

    }

    fun <DataViewHolder : RecyclerView.ViewHolder> DataViewHolder.listen(event: (position: Int, type: Int) -> Unit): DataViewHolder {
        itemView.setOnClickListener {
            if (getItemViewType() != 1) {
                event.invoke(0, getItemViewType())
            } else {
                event.invoke(adapterPosition, getItemViewType())
            }
        }
        return this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : DataViewHolder {
        when (mItemViewType) {
            1 -> {
                val inflater = LayoutInflater.from(parent.getContext())
                val view = inflater.inflate(R.layout.layout_profileinfo_list_item, parent, false)
                return DataViewHolder(view).listen { pos, type ->
                    val item = profileData.get(pos)
                    onItemClick?.invoke(item)
                }
            }
            else -> {
                val inflater = LayoutInflater.from(parent.getContext())
                val view = inflater.inflate(R.layout.layout_profile_image, parent, false)
                cardView = DataViewHolder(view).getCardView()!!
                DataViewHolder(cardView).listen { pos, type ->
                    val item = profileData.get(pos)
                    onItemClick?.invoke(item)
                }
                return DataViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int = profileData.size

    override fun onBindViewHolder(holder: MainAdapter.DataViewHolder, position: Int) {
        holder.bind(profileData[position])
    }

    fun addData(list: List<ProfileInfo>) {
        profileData.addAll(list)
    }

    override fun getItemViewType(position: Int): Int {
        if (position > 0) {
            mItemViewType = 1
            return 1
        } else {
            mItemViewType = 0
            return 0
        }
    }
}
