package dev.iamspathan.androidtrack.sixthsession

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.iamspathan.androidtrack.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    val TAG = "FRAGMENTDEMO"

    val NAME = "FirstFragment"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "$NAME OnAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$NAME OnCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "$NAME OnCreateView")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "$NAME OnActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$NAME OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$NAME OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$NAME OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$NAME OnStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "$NAME OnDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$NAME OnDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "$NAME OnDetach")
    }
}