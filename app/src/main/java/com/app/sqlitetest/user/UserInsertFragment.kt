package com.app.sqlitetest.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.sqlitetest.databinding.UserInsertBinding

class UserInsertFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View{
        val binding = UserInsertBinding.inflate(inflater, container, false)
        binding.viewModel = UserInsertViewModel(

        )

        return binding.root
    }

}