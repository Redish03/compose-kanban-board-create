package woowacourse.kanban.board.data

import androidx.annotation.ColorRes

enum class TaskStatus {
    TO_DO,
    IN_PROGRESS,
    DONE,
}

enum class TaskStatusUIModel(@ColorRes val color: Int, val text: String) {
    TO_DO(color = 1234556, text = "Abc"),
    IN_PROGRESS(color = 1234556, text = "Abc"),
    DONE(color = 1234556, text = "Abc");

    companion object {
        fun TaskStatusUIModel.toDomain(): TaskStatus {
            return when (this) {
                TaskStatusUIModel.TO_DO -> TaskStatus.TO_DO
                TaskStatusUIModel.IN_PROGRESS -> TaskStatus.IN_PROGRESS
                TaskStatusUIModel.DONE -> TaskStatus.DONE
            }
        }

        fun TaskStatus.toUIModel(): TaskStatusUIModel {
            return when (this) {
                TaskStatus.TO_DO -> TO_DO
                TaskStatus.IN_PROGRESS -> IN_PROGRESS
                TaskStatus.DONE -> DONE
            }
        }
    }

}
