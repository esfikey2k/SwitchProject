package com.example.switchproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.switchproject.databinding.FragmentChoiceBinding


class ChoiceFragment : Fragment() {

    private var _binding: FragmentChoiceBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChoiceBinding.inflate(inflater, container, false)
        val view = binding.root


        try {

            setEnabled()

            binding.switcEgo.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    binding.switchHappiness.isEnabled = false
                    binding.switchGiving.isEnabled = false
                    binding.switchKindness.isEnabled = false
                    binding.switchOptimism.isEnabled = false
                    binding.switchRespect.isEnabled = false

                    (activity as? MainActivity)?.addHappinessFragmentToBottomNav(false)
                    (activity as? MainActivity)?.addGivingFragmentToBottomNav(false)
                    (activity as? MainActivity)?.addKindnessFragmentToBottomNav(false)
                    (activity as? MainActivity)?.addOptimismFragmentToBottomNav(false)
                    (activity as? MainActivity)?.addRespectFragmentToBottomNav(false)
                    (activity as? MainActivity)?.hideBottomNav(true)

                    binding.switchGiving.isChecked= false
                    binding.switchKindness.isChecked= false
                    binding.switchHappiness.isChecked= false
                    binding.switchOptimism.isChecked= false
                    binding.switchRespect.isChecked= false
                }else{

                    binding.switchHappiness.isEnabled = true
                    binding.switchGiving.isEnabled = true
                    binding.switchKindness.isEnabled = true
                    binding.switchOptimism.isEnabled = true
                    binding.switchRespect.isEnabled = true
                    (activity as? MainActivity)?.hideBottomNav(false)

                }

            }


            binding.switchHappiness.setOnCheckedChangeListener{_, isChecked ->
                (activity as? MainActivity)?.addHappinessFragmentToBottomNav(isChecked)
            }

            binding.switchGiving.setOnCheckedChangeListener{_, isChecked ->
                (activity as? MainActivity)?.addGivingFragmentToBottomNav(isChecked)
            }

            binding.switchKindness.setOnCheckedChangeListener{_, isChecked ->
                (activity as? MainActivity)?.addKindnessFragmentToBottomNav(isChecked)
            }

            binding.switchOptimism.setOnCheckedChangeListener{_, isChecked ->
                (activity as? MainActivity)?.addOptimismFragmentToBottomNav(isChecked)
            }

            binding.switchRespect.setOnCheckedChangeListener{_, isChecked ->
                (activity as? MainActivity)?.addRespectFragmentToBottomNav(isChecked)
            }

        }catch (e: Exception){
            e.printStackTrace()
        }




        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setEnabled(){
        binding.switcEgo.isChecked = true
        binding.switchHappiness.isEnabled = false
        binding.switchGiving.isEnabled = false
        binding.switchKindness.isEnabled = false
        binding.switchOptimism.isEnabled = false
        binding.switchRespect.isEnabled = false
        (activity as? MainActivity)?.hideBottomNav(true)
    }


}