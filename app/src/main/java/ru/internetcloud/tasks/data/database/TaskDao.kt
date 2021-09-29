package ru.internetcloud.tasks.data.database


import androidx.room.*
import ru.internetcloud.tasks.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task ORDER BY id DESC")
    fun getTaskList(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTask(task: Task): Long

    @Update
    fun updateTask(task: Task): Int

    @Delete
    fun deleteTask(task: Task): Int

}