package ru.internetcloud.tasks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.internetcloud.tasks.data.model.TaskCategory

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val isCompleted: Boolean,

    @ColumnInfo(name = "category")
    @TypeConverters(TaskCategory::class)
    val category: TaskCategory
)
