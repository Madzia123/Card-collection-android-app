package com.magdalena.cardcollection.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Card::class, Category::class],
    version = 1,
    exportSchema = false
)
abstract class CardRoomDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun categoryDao(): CategoryDao
}