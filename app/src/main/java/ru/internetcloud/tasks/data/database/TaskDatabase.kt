package ru.internetcloud.tasks.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.internetcloud.tasks.Task
import ru.internetcloud.tasks.data.model.TaskCategory

@Database(entities = [Task::class], version = 1, exportSchema = true)
@TypeConverters(TaskCategoryConverter::class)
abstract class TaskDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        private var INSTANCE: TaskDatabase? = null
        fun getInstance(context: Context): TaskDatabase? {
            if (INSTANCE == null) {
                synchronized(TaskDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        TaskDatabase::class.java, "best_todo_database"
                    ).build()
                }
            }
            return INSTANCE
        }
        val PREPOPULATE_DATA = listOf(
            Task(
                1,
                "Прочитать книгу Рефакторинг",
                false,
                category = TaskCategory.STUDY
            ),
            Task(
                2,
                "Купить авиабилеты",
                false,
                category = TaskCategory.PERSONAL
            )
        )
    }

}