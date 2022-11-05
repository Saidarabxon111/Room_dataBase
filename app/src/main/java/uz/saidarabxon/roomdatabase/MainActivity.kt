package uz.saidarabxon.roomdatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.saidarabxon.roomdatabase.adapters.MyRv
import uz.saidarabxon.roomdatabase.databinding.ActivityMainBinding
import uz.saidarabxon.roomdatabase.db.AppDataBase
import uz.saidarabxon.roomdatabase.db.MyContact

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appDataBase: AppDataBase
    private lateinit var rv: MyRv
    private lateinit var list: ArrayList<MyContact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        appDataBase = AppDataBase.getInstance(this)




        binding.btnSave.setOnClickListener {
            val myContact = MyContact(
                binding.edtName.text.toString(),
                binding.edtNumber.text.toString()
            )
            appDataBase.mycontactDao().addContact(myContact)
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()

        list = ArrayList()
        list.addAll(appDataBase.mycontactDao().getAllContacts())


        rv = MyRv(list)

        binding.rv.adapter = rv
    }
}