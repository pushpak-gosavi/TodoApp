package com.jetpack.todo.data.repositories

import com.jetpack.todo.data.ToDoDao
import com.jetpack.todo.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepositories @Inject constructor(private val toDoDao: ToDoDao) {

    val getAllTasks : Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority : Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority : Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId:Int) :Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask){
        toDoDao.addTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask){
        toDoDao.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask){
        toDoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAll(){
        toDoDao.deleteAllTasks()
    }

    fun  searchDatabase(searchQuery:String) : Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(searchQuery = searchQuery)
    }
}