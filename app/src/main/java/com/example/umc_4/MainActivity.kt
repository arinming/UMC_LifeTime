package com.example.umc_4


import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.umc_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var edtText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this,"액티비티 생성",Toast.LENGTH_SHORT).show()
        binding.btnMain.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", binding.edtMain.text.toString())
            edtText = binding.edtMain.text.toString()
            Toast.makeText(this,"데이터 전달",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        edtText = binding.edtMain.text.toString()
        binding.edtMain.setText(edtText)
    }

    override fun onRestart() {
        super.onRestart()
        val dialogMsg = AlertDialog.Builder(this)
        dialogMsg
            .setMessage("이어서 작성하시겠습니까?")
            .setPositiveButton("예",
            DialogInterface.OnClickListener{ dialog, id ->
                edtText = binding.edtMain.text.toString()
                binding.edtMain.setText(edtText)
            })
            .setNegativeButton("아니요",
            DialogInterface.OnClickListener{ dialog, id ->
                edtText = ""
                binding.edtMain.setText(edtText)
            })
        dialogMsg.show()
   }
}