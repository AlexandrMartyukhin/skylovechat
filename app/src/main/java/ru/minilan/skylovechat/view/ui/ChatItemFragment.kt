package ru.minilan.skylovechat.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.minilan.skylovechat.R
import ru.minilan.skylovechat.view.adapters.MyChatItemRecyclerViewAdapter
import ru.minilan.skylovechat.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 */
class ChatItemFragment : Fragment() {

    private var chatId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            chatId = it.getInt(CHAT_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    chatId <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, chatId)
                }
                adapter = MyChatItemRecyclerViewAdapter(DummyContent.ITEMS)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val CHAT_ID = "CHAT_ID"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ChatItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(CHAT_ID, columnCount)
                }
            }
    }
}