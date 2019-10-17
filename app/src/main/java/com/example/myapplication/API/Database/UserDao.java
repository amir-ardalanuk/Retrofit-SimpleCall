package com.example.myapplication.API.Database;

import androidx.room.*;
import com.example.myapplication.model.account.UserAccount;

@Dao
public interface UserDao {
    @Insert
    Long insert(UserAccount userAccounUt);


    @Query("Select * from user")
    UserAccount getUser();


    @Update
    void update(UserAccount user);


    @Delete
    void delete(UserAccount user);
}

