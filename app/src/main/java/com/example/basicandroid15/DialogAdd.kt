package com.example.basicandroid15

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment


open class DialogAdd : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dialog,container,false)
        // ánh xạ các view trong dialogfragment
        val nameEditText: EditText = view.findViewById(R.id.edtName)
        val ageEditText: EditText = view.findViewById(R.id.edtAge)
        val sexEditText: EditText = view.findViewById(R.id.edtSex)
        val btnOk : Button = view.findViewById(R.id.btnOK)

        btnOk.setOnClickListener {
            // lấy thông tin từ edt
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toInt()
            val sex = sexEditText.text.toString()
            // thêm user vào danh sách và cập nhật rcv
            val user = UserItem(name,age,sex)
            (activity as? MainActivity)?. addUser(user)

            // đóng diaglog
            dismiss()
        }
        return view
    }
}