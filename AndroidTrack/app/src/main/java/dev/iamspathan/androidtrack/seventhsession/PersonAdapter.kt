package dev.iamspathan.androidtrack.seventhsession

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.iamspathan.androidtrack.R

// Inherit Recyclerview.Adaterc Class



class PersonAdapter(private val personList: List<Person>, val context: Context ) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_person_layout,parent,false)
       return PersonViewHolder(view)
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

    class PersonViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val peronTitle = view.findViewById<TextView>(R.id.personNameTextView)
        val profileImage = view.findViewById<ImageView>(R.id.personImageView)
        val personCity = view.findViewById<TextView>(R.id.personPlaceTextView)
        val personFrvtFodd = view.findViewById<TextView>(R.id.personPlaceFvrtFood)

        fun bind(person: Person) {
            peronTitle.text = person.name
            profileImage.setImageResource(person.profileImage)
            personCity.text = person.city
            personFrvtFodd.text = person.fvrtFood
        }

    }

    }
