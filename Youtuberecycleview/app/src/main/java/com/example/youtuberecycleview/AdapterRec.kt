package drawable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtuberecycleview.databinding.ActivityMainBinding
import com.example.youtuberecycleview.databinding.RvViewBinding

class AdapterRec (var dataList: ArrayList<Model>): RecyclerView.Adapter<AdapterRec.viewHolder>() {

    inner class viewHolder(var binding: RvViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
       var binding=RvViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return viewHolder((binding))

    }

    override fun getItemCount(): Int {

        return dataList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
       holder.binding.big.setImageResource(dataList.get(position).mainImg)
       holder.binding.small.setImageResource(dataList.get(position).profileImg)
        holder.binding.textView.text=dataList.get(position).text
    }


}


