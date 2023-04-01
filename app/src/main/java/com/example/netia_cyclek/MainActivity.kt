package com.example.netia_cyclek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netia_cyclek.adapters.NetiaAdapter
import com.example.netia_cyclek.databinding.ActivityMainBinding
import com.example.netia_cyclek.viewmodel.NetiaViewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var adp: NetiaAdapter
    private val vm: NetiaViewModel by viewModels()
    private val id = Random().nextInt()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        adp = NetiaAdapter(layoutInflater, vm.startTime)
        addEvent("onCreate()")

        binding.rec.layoutManager = LinearLayoutManager(this)
        binding.rec.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        binding.rec.adapter = adp
    }

    override fun onStart() {
        super.onStart()

        addEvent("onStart()")
    }

    override fun onResume() {
        super.onResume()

        addEvent("onResume()")
    }

    override fun onPause() {
        addEvent("onPause()")

        super.onPause()
    }

    override fun onStop() {
        addEvent("onStop()")

        super.onStop()
    }

    override fun onDestroy() {
        addEvent("onDestroy()")

        super.onDestroy()
    }

    private fun addEvent(message: String) {
        vm.addEvent(message, id)
        adp.submitList(ArrayList(vm.netia))
    }
}