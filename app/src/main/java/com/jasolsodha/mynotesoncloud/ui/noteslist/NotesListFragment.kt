package com.jasolsodha.mynotesoncloud.ui.noteslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.jasolsodha.mynotesoncloud.databinding.FragmentNotesListBinding
import com.js.jskotlindemo.coromind.viewmodel.ViewModelProviderFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NotesListFragment : Fragment() {

    lateinit var viewDataBinding: FragmentNotesListBinding

    lateinit var contextActivity : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contextActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewDataBinding = FragmentNotesListBinding.inflate(inflater, container, false)
        val factory = ViewModelProviderFactory()
        ViewModelProviders.of(this).get(NotesListViewModel::class.java)

    }


//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false).apply {
//            viewmodel = ViewModelProviders.of(this@RepoListFragment).get(RepoListViewModel::class.java)
//            setLifecycleOwner(viewLifecycleOwner)
//        }
//        return viewDataBinding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_NotesListFragment_to_AddNoteFragment)
//        }
    }
}