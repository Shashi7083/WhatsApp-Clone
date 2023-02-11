package com.example.whatsappclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.whatsappclone.activity.NumberActivity
import com.example.whatsappclone.adapter.ViewPagerAdapter
import com.example.whatsappclone.databinding.ActivityMainBinding
import com.example.whatsappclone.ui.CallFragment
import com.example.whatsappclone.ui.ChatFragment
import com.example.whatsappclone.ui.StatusFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
    private lateinit var auth : FirebaseAuth
    var tabTitle = arrayOf("Chat ","Status","Call")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding!!.root)

        auth = FirebaseAuth.getInstance()
        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(ChatFragment())
        fragmentArrayList.add(StatusFragment())
        fragmentArrayList.add(CallFragment())

        if(auth.currentUser==null){
            val intent = Intent(this@MainActivity,NumberActivity::class.java)
            startActivity(intent)
            finish()
        }


        val adapter = ViewPagerAdapter(this,supportFragmentManager,fragmentArrayList,lifecycle)

        binding!!.viewPager.adapter = adapter

      //  binding!!.tabs.setupWithViewPager(binding!!.viewPager)
        TabLayoutMediator(binding!!.tabs,binding!!.viewPager){
            tab,position->
            tab.text = tabTitle[position]
        }.attach()
    }


}
