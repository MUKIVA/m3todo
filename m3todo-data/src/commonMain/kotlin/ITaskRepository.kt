import kotlinx.coroutines.flow.Flow
import models.Task

interface ITaskRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun addTask(task: Task)
    suspend fun removeTask(task: Task)
}