package com.sithuhein.mm.hanacodetest.presentation.ui.responseone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sithuhein.mm.hanacodetest.databinding.ResponseOneItemBinding
import com.sithuhein.mm.hanacodetest.domain.model.ResponseOne
import com.sithuhein.mm.hanacodetest.presentation.ui.responseone.ResponseOneFragmentAdapter.ResponseOneViewHolder

class ResponseOneFragmentAdapter : RecyclerView.Adapter<ResponseOneViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseOneViewHolder {

        val responseOneItemBinding = ResponseOneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResponseOneViewHolder(responseOneItemBinding)
    }

    override fun onBindViewHolder(holder: ResponseOneViewHolder, position: Int) {
        val responseOne = list[position]
        holder.bind(responseOne)

    }

    override fun getItemCount(): Int = list.size

    private val diffCallback = object : DiffUtil.ItemCallback<ResponseOne>() {
        override fun areItemsTheSame(oldItem: ResponseOne, newItem: ResponseOne): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResponseOne, newItem: ResponseOne): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var responseOneList : List<ResponseOne>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    private var list = mutableListOf<ResponseOne>()
    fun setList(data: List<ResponseOne>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }


    class ResponseOneViewHolder(private val responseOneItemBinding: ResponseOneItemBinding): RecyclerView.ViewHolder(responseOneItemBinding.root) {

        fun bind(data : ResponseOne) {
            responseOneItemBinding.userId.text = data.userId
            responseOneItemBinding.title.text = data.title
            responseOneItemBinding.body.text = data.body
        }
    }

}


