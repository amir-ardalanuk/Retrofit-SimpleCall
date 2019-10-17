package com.example.myapplication.API.Database

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import com.example.myapplication.model.account.UserAccount
import android.os.AsyncTask
import androidx.room.Room


@Database(entities = [UserAccount::class], version = 1,exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun daoAccess(): UserDao



    companion object{
        private var instance: UserDatabase? = null
        fun getInstance(context: Context): UserDatabase? {
            if (instance == null) {
                synchronized(UserAccount::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(object : RoomDatabase.Callback() {

                        })
                        .build()
                }
            }
            return instance
        }
    }

}

class UserRepository(context: Context) {

    private var userDatabase: UserDatabase? = null

    private var userDao: UserDao? = null


    init {
        userDatabase = UserDatabase.getInstance(context)
        this.userDao = userDatabase?.daoAccess()

    }

    @JvmOverloads
    fun insertTask(user : UserAccount) {
        userDao?.insert(user)
    }

    val user: UserAccount?
        get() = userDao?.user

    @SuppressLint("StaticFieldLeak")
    fun update(user: UserAccount) {
        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg voids: Void): Void? {
               userDao?.update(user)
                return null
            }
        }.execute()
    }

}