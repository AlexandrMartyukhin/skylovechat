package ru.minilan.skylovechat.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ru.minilan.skylovechat.R
import ru.minilan.skylovechat.databinding.FragmentChatListBinding
import ru.minilan.skylovechat.view.adapters.MyChatListRecyclerViewAdapter
import ru.minilan.skylovechat.dummy.DummyContent
import ru.minilan.skylovechat.view.callbacks.ChatClickCallback

/**
 * A fragment representing a list of Items.
 */
class ChatListFragment : Fragment() {
//    private lateinit var binding: FragmentChatListBinding
    private val chatClickCallback = object : ChatClickCallback {
        override fun onChatClick(chatId: Int) {
            (activity as MainActivity).onChatSelected(chatId)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        val binding = DataBindingUtil.inflate<FragmentChatListBinding>(inflater, R.layout.fragment_chat_list, container, false)
//
        binding.chatList.adapter = MyChatListRecyclerViewAdapter(DummyContent.ITEMS, chatClickCallback)
        // Set the adapter
//        if (binding.root is RecyclerView) {
//            with(view) {
//                layoutManager = LinearLayoutManager(context)
//
//                adapter = MyChatListRecyclerViewAdapter(DummyContent.ITEMS)
//            }
//        }
        binding.isLoading = true
        return binding.root
//        return view
    }

    companion object {

        // TODO: Customize parameter argument names
//        const val ARG_COLUMN_COUNT = "column-count"

//        // TODO: Customize parameter initialization
//        @JvmStatic
//        fun newInstance(columnCount: Int) =
//            ChatListFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_COLUMN_COUNT, columnCount)
//                }
//            }
    }
}