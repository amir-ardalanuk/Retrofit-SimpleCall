package com.example.myapplication.API.Database;

import androidx.room.*;
import com.example.myapplication.model.account.UserAccount;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert(onConflict = REPLACE)
    Long insert(UserAccount userAccounUt);


    @Query("Select * from user")
    UserAccount getUser();


    @Update(onConflict = REPLACE)
    void update(UserAccount user);


    @Delete
    void delete(UserAccount user);
}

