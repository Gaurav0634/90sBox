import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a90sbox.MainActivity
import com.example.a90sbox.R

class TitleAdapter(private val items: List<MainActivity.Item>) : RecyclerView.Adapter<TitleAdapter.ViewHolder>() {

    private var onItemClick: ((MainActivity.Item) -> Unit)? = null

    fun setOnItemClickListener(listener: (MainActivity.Item) -> Unit) {
        onItemClick = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_title, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.titleTextView.text = item.title
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
