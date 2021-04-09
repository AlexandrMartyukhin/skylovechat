package ru.minilan.skylovechat.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.minilan.skylovechat.R
import ru.minilan.skylovechat.view.callbacks.IOnChatSelected
import ru.minilan.skylovechat.view.ui.ChatItemFragment.Companion.CHAT_ID

class MainActivity : AppCompatActivity(), IOnChatSelected {
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
    }

    override fun onChatSelected(chatId: Int) {
        val bundle = bundleOf(
            Pair(CHAT_ID, chatId)
        )
        navController.navigate(R.id.chat_item_fragment, bundle)
    }
}