package utils

import com.github.mukiva.m3todo.database.models.TaskDbo
import models.Task

fun asTask(dbo: TaskDbo): Task {
    return Task(
        id = dbo.id,
        title = dbo.title
    )
}

fun asTaskDbo(task: Task): TaskDbo {
    return TaskDbo(
        id = task.id,
        title = task.title
    )
}