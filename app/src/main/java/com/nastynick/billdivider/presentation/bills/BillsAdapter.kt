package com.nastynick.billdivider.presentation.bills

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Bill
import kotlinx.android.synthetic.main.item_bill.view.*
import javax.inject.Inject

class BillsAdapter @Inject constructor() : RecyclerView.Adapter<BillsAdapter.ViewHolder>() {
    private var bills: List<Bill> = listOf()

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        bills[position].let(viewHolder::bind)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bill, parent, false)
                .let(this::ViewHolder)
    }

    override fun getItemCount() = bills.size

    fun setData(bills: List<Bill>) {
        this.bills = bills
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(bill: Bill) {
            with(bill.details) {
                view.itemBillTextViewName.setText(name)
                view.itemBillTextViewAddress.setText(address)
            }
        }
    }
}