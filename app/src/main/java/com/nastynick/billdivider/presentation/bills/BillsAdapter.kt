package com.nastynick.billdivider.presentation.bills

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.nastynick.billdivider.domain.model.bills.Bill
import javax.inject.Inject


class BillsAdapter @Inject constructor() : RecyclerView.Adapter<BillsAdapter.ViewHolder>() {
    private var bills: List<Bill> = listOf()

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        bills[position].let(viewHolder::bind)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LinearLayout(parent.context))
    }

    override fun getItemCount() = bills.size

    fun setData(bills: List<Bill>) {
        this.bills = bills
        Log.i("BillsAdapter", "bills $bills ${bills.size}")
    }

    inner class ViewHolder(val view: LinearLayout) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = TextView(view.context)

        init {
            view.addView(textView)
        }

        fun bind(bill: Bill) {
            textView.text = bill.id
        }
    }
}