package com.fuadhev.findmovie.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fuadhev.findmovie.model.FavoritMovie


@Database(entities = [FavoritMovie::class], version = 1)
abstract class MyRoomDatabase:RoomDatabase() {

    abstract fun movieDao():MovieDao



//    companion object{
//        private var instance: MyRoomDatabase? = null
//
//        fun getInstance(context: Context): MyRoomDatabase {
//            return instance ?: synchronized(this) {
//                val databaseBuilder = Room.databaseBuilder(
//                    context.applicationContext,
//                    MyRoomDatabase::class.java,
//                    "note_database"
//                )
//                instance = databaseBuilder.build()
//                instance!!
//            }
//        }
//        }

}