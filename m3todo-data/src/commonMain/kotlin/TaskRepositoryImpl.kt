import com.gihub.mukiva.m3todo.database.DatabaseWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import models.Task
import utils.asTask
import utils.asTaskDbo

internal class TaskRepositoryImpl(
    private val databaseWrapper: DatabaseWrapper
) : ITaskRepository {
    override fun getAllTasks(): Flow<List<Task>> {
        return databaseWrapper.taskDao.getAllTasks()
            .map { tasks -> tasks.map(::asTask) }
    }

    override suspend fun addTask(task: Task) {
        databaseWrapper.taskDao.upsert(asTaskDbo(task))
    }

    override suspend fun removeTask(task: Task) {
        databaseWrapper.taskDao.delete(asTaskDbo(task))
    }

}

fun createTaskRepository(
    databaseWrapper: DatabaseWrapper
): ITaskRepository {
    return TaskRepositoryImpl(databaseWrapper)
}