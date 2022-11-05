package uz.saidarabxon.roomdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [MyContact::class], version = 1)
abstract class AppDataBase :RoomDatabase(){


    abstract fun mycontactDao():MyContactDao

    companion object{
        private  var appDataBase  :AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context):AppDataBase{
            if (appDataBase==null){
                appDataBase = Room.databaseBuilder(context,AppDataBase::class.java,"contact")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return  appDataBase!!
        }
    }

}