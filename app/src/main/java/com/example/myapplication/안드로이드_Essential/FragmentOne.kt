package com.example.myapplication.안드로이드_Essential

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityFragmentOneBinding

class FragmentOne : Fragment(R.layout.activity_fragment_one) {
    private var fragmentOneBinding: ActivityFragmentOneBinding?= null

    interface OnDataPassListener {
        fun onDataPass(data: String?)
    }

    lateinit var dataPassListener: OnDataPassListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("life_cycle_fragment", "onAttach")
        // 형변환
        dataPassListener = context as OnDataPassListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("life_cycle_fragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle_fragment", "onCreateView")

        // 뷰를 그리는 역할
        // Fragment 인터페이스를 처음으로 그릴 때 호출됨
        // inflater : 뷰를 그려줌
        // container : 부모 뷰
        return inflater.inflate(R.layout.activity_fragment_one, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("life_cycle_fragment", "onViewCreated")

        val binding = ActivityFragmentOneBinding.bind(view)
        fragmentOneBinding = binding

        // Activity onCreate 작업을 Fragment 경우 여기서 진행한다
        binding.pass.setOnClickListener {
            dataPassListener.onDataPass("Pass Data in Fragment")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("life_cycle_fragment", "onActivityCreated")
        val data = arguments?.getString("hello")
        Log.d("life_cycle_data", data.toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle_fragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle_fragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle_fragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle_fragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("life_cycle_fragment", "onDestroyView")
        fragmentOneBinding = null
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("life_cycle_fragment", "onDetach")
    }
}