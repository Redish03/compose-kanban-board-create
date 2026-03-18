package woowacourse.kanban.board.data

data class Title(val titleText: String) {
    init {
        require(titleText.isNotBlank()) { "할 일의 제목은 빈칸이거나 공백 일 수 없습니다." }
    }
}
