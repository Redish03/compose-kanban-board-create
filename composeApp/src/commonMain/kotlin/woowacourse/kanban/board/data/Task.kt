package woowacourse.kanban.board.data

data class Task(
    val taskTitle: String,
    val taskScript: String = "",
    val tags: List<String> = emptyList(),
    val nickname: String,
) {
    init {
        require(taskTitle.isNotBlank()) { "할 일의 제목은 빈칸이거나 공백 일 수 없습니다." }
        require(nickname.isNotBlank()) { "사용자 이름은 빈칸이거나 공백 일 수 없습니다." }
    }
}
