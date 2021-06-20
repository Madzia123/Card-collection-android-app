package com.magdalena.cardcollection.inject


import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.magdalena.cardcollection.database.CardDao
import com.magdalena.cardcollection.database.CardRoomDatabase
import com.magdalena.cardcollection.database.CategoryDao
import com.magdalena.cardcollection.manger.CardDatabaseManger
import com.magdalena.cardcollection.utils.CARD_DATABASE
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesDatabase(context: Context): CardRoomDatabase {
        return Room.databaseBuilder(
            context, CardRoomDatabase::class.java,
            CARD_DATABASE
        ).setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesCardDao(database: CardRoomDatabase) = database.cardDao()

    @Singleton
    @Provides
    fun providesCategoryDao(database: CardRoomDatabase) = database.categoryDao()

    @Provides
    fun providesCardDatabaseManger(dao: CardDao) = CardDatabaseManger(dao)


}