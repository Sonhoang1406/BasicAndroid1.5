package com.example.basicandroid15

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val userList = ArrayList<UserItem>()
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAdd: Button
    lateinit var name: Array<String>
    lateinit var age: Array<Int>
    lateinit var sex: Array<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            showDialog()
        }

        recyclerView = findViewById(R.id.rcvUser)

        name = arrayOf(
            "Son",
            "Ha",
            "Hoang",
            "Anh",
            //"Tu",
            //"Dap",
            //"Dao",
            //"Hung",
            //"Tuan",
           // "Cuong",
        )
        age = arrayOf(
            23,
            34,
            43,
            42,
            //41,
            //33,
            //13,
            //53,
            //23,
            //33,
        )
        sex = arrayOf(
            "Male",
            "Female",
            "Male",
            "Female",
//            "Female",
//            "Male",
//            "Female",
//            "Male",
//            "Male",
//            "Female",
        )

        fun getUserData(){
            for(i in name.indices){
                val user = UserItem(name[i],age[i],sex[i])
                userList.add(user)
            }
        }
        userAdapter = UserAdapter(userList)
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        getUserData()
    }

    private fun showDialog() {
        val dialog = DialogAdd()
        dialog.show(supportFragmentManager,"DialogAddUser")
    }

    fun addUser(user: UserItem) {
            userList.add(user)
            userAdapter.notifyDataSetChanged()
    }
}