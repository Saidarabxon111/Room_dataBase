package uz.saidarabxon.roomdatabase.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.saidarabxon.roomdatabase.databinding.ItemRvBinding
import uz.saidarabxon.roomdatabase.db.MyContact

class MyRv(var list: List<MyContact>) : RecyclerView.Adapter<MyRv.Vh>() {

    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(myContact: MyContact, position: Int ){
            itemRvBinding.tvName.text =myContact.name
            itemRvBinding.tvNumber.text =myContact.number

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}