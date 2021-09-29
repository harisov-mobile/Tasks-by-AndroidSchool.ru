package ru.internetcloud.tasks

import androidx.room.Entity
import ru.internetcloud.tasks.data.model.TaskCategory

@Entity
data class Task(
    val id: Int = 0,
    val title: String,
    val isCompleted: Boolean,
    val category: TaskCategory
)
