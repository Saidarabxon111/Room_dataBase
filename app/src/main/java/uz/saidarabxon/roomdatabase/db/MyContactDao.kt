package uz.saidarabxon.roomdatabase.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyContactDao {
@Insert
    fun addContact(myContact: MyContact)

    @Query("select * from mycontact")
    fun getAllContacts():List<MyContact>
}