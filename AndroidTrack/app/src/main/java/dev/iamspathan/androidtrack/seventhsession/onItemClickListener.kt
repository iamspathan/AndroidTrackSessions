package dev.iamspathan.androidtrack.seventhsession

import java.text.FieldPosition


/* Best Practise to make OnItemClickListener
* -> Create New Click Interface
* -> Implement the Interface in Activity
* -> Implement View.OnClickListener in ViewHolder Class
* -> Implement CustomInterface in Adapter
* */

interface OnPersonClickListener {
    fun onPersonClick(position:Int)
}