package woowacourse.kanban.board.data

class Tasks(private val tasks: MutableList<Task>) {
    fun addNewTask(
        title: String,
        description: String,
        tags: String,
        selectedStatus: String,
        selectedProfile: String,
    ) {
        tasks.add(
            Task(
                taskTitle = Title(title),
                taskScript = Script(description),
                tags = Tags(splitTags(tags)),
                status = statusToTaskStatus(selectedStatus),
                nickname = profileToNickname(selectedProfile),
            ),
        )
    }

    fun todoStatusTasks(): List<Task> = tasks.filter { it.status == TaskStatus.TO_DO }
    fun inProgressStatusTasks(): List<Task> = tasks.filter { it.status == TaskStatus.IN_PROGRESS }
    fun doneStatusTasks(): List<Task> = tasks.filter { it.status == TaskStatus.DONE }
    fun splitTags(tags: String): List<String> = if (tags.isBlank()) {
        emptyList()
    } else {
        tags.split(',').map { it.trim() }.filter { it.isNotBlank() }
    }

    private fun statusToTaskStatus(status: String): TaskStatus =
        when (status) {
            "To Do" -> TaskStatus.TO_DO
            "In Progress" -> TaskStatus.IN_PROGRESS
            "Done" -> TaskStatus.DONE
            else -> throw IllegalArgumentException("Invalid status: $status")
        }

    private fun profileToNickname(profile: String): Nickname =
        when (profile) {
            "다이노" -> Nickname("다이노")
            "페임스" -> Nickname("페임스")
            else -> throw IllegalArgumentException("Invalid profile: $profile")
        }
}
