package dev.iamspathan.androidtrack.seventhsession

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.iamspathan.androidtrack.R

// Inherit Recyclerview.Adaterc Class



class PersonAdapter(private val personList: List<Person>, val context: Context, val onPersonClickListener: OnPersonClickListener ) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_person_layout,parent,false)
       return PersonViewHolder(view,onPersonClickListener)
    }


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

//        with(holder) {
//            peronTitle.text = personList[position].name
//            profileImage.setImageResource(personList[position].profileImage)
//            personCity.text = personList[position].city
//            personFrvtFodd.text = personList[position].fvrtFood
//        }
        holder.bind(personList[position])


    }

    override fun getItemCount(): Int {
        return personList.size
    }

    class PersonViewHolder(val itemView: View, val onPersonClickListener: OnPersonClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val peronTitle = itemView.findViewById<TextView>(R.id.personNameTextView)
        val profileImage = itemView.findViewById<ImageView>(R.id.personImageView)
        val personCity = itemView.findViewById<TextView>(R.id.personPlaceTextView)
        val personFrvtFodd = itemView.findViewById<TextView>(R.id.personPlaceFvrtFood)

        fun bind(person: Person) {
            peronTitle.text = person.name
            Glide.with(itemView.context).load(person.profileImage)
                .centerCrop()
                .into(profileImage)
            personCity.text = person.city
            personFrvtFodd.text = person.fvrtFood
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            onPersonClickListener.onPersonClick(adapterPosition)
        }
    }

    }
