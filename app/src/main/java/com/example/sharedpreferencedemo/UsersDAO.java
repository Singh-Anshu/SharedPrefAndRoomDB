package com.example.sharedpreferencedemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UsersDAO {

    @Query("SELECT * FROM users")
    List<Users> getAllUsers();

    @Insert
    void insert(Users users);

    @Update
    void update(Users users);

    @Delete
    void delete(Users users);
}
