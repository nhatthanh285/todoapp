package com.dat.androidhmi.composetodolist.foundation.datasource.local

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dat.androidhmi.composetodolist.foundation.datasource.local.converter.DateConverter
import com.dat.androidhmi.composetodolist.foundation.datasource.local.dao.ToDoGroupReadDao
import com.dat.androidhmi.composetodolist.foundation.datasource.local.dao.ToDoGroupWriteDao
import com.dat.androidhmi.composetodolist.foundation.datasource.local.dao.ToDoListReadDao
import com.dat.androidhmi.composetodolist.foundation.datasource.local.dao.ToDoListWriteDao
import com.dat.androidhmi.composetodolist.foundation.datasource.local.dao.ToDoStepReadDao
import com.dat.androidhmi.composetodolist.foundation.datasource.local.dao.ToDoStepWriteDao
import com.dat.androidhmi.composetodolist.foundation.datasource.local.dao.ToDoTaskReadDao
import com.dat.androidhmi.composetodolist.foundation.datasource.local.dao.ToDoTaskWriteDao
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoGroupDb
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoListDb
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoStepDb
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoTaskDb
import com.dat.androidhmi.composetodolist.foundation.datasource.local.model.ToDoTaskFtsDb
import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProviderImpl
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(
    entities = [
        ToDoGroupDb::class,
        ToDoListDb::class,
        ToDoTaskDb::class,
        ToDoTaskFtsDb::class,
        ToDoStepDb::class
    ],
    version = 2,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ],
)
@TypeConverters(DateConverter::class)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoGroupWriteDao(): ToDoGroupWriteDao
    abstract fun toDoListWriteDao(): ToDoListWriteDao
    abstract fun toDoTaskWriteDao(): ToDoTaskWriteDao
    abstract fun toDoStepWriteDao(): ToDoStepWriteDao
    abstract fun toDoGroupReadDao(): ToDoGroupReadDao
    abstract fun toDoListReadDao(): ToDoListReadDao
    abstract fun toDoTaskReadDao(): ToDoTaskReadDao
    abstract fun toDoStepReadDao(): ToDoStepReadDao

    @DelicateCoroutinesApi
    companion object {
        private const val TODO_DB_NAME = "todo-db"

        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getInstance(context: Context): ToDoDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): ToDoDatabase {
            val db = Room.databaseBuilder(
                context,
                ToDoDatabase::class.java,
                TODO_DB_NAME
            )
                .addCallback(
                    object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            GlobalScope.launch(Dispatchers.IO) {
                                initPrePopulateDefaultGroup(context)
                            }
                        }
                    }
                )
                .fallbackToDestructiveMigration()

            return db.build()
        }

        private suspend fun initPrePopulateDefaultGroup(context: Context) {
            val currentDate = DateTimeProviderImpl().now()
            val defaultGroup = ToDoGroupDb(
                id = ToDoGroupDb.DEFAULT_ID,
                name = "Others",
                createdAt = currentDate,
                updatedAt = currentDate
            )
            val writeDao = getInstance(context).toDoGroupWriteDao()

            writeDao.insertGroup(listOf(defaultGroup))
        }

    }
}
