package com.ppmgto.yearbook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ppmgto.yearbook.databinding.PersonItemBinding

data class Person (
    val name: String,
    val imageId: Int,
    val onClick: (Int) -> Unit,
)

class PersonAdapter : ListAdapter<Person, PersonAdapter.ReelsItemViewHolder>(
    ReelDataDiffCallBack()
) {

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReelsItemViewHolder {
        val binding = PersonItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReelsItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonAdapter.ReelsItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun onViewDetachedFromWindow(holder: ReelsItemViewHolder) {
        super.onViewDetachedFromWindow(holder)
    }

    override fun onBindViewHolder(
        holder: ReelsItemViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        onBindViewHolder(holder, position)
    }

    inner class ReelsItemViewHolder(private val binding: PersonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val person = getItem(position)
            binding.personIv.setImageResource(person.imageId)
            binding.name.text = person.name
            binding.root.setOnClickListener{
                person.onClick.invoke(person.imageId)
            }
        }
    }

    private class ReelDataDiffCallBack : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean =
            oldItem.name == newItem.name
    }
}