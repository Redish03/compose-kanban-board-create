package woowacourse.kanban.board.data

data class Nickname(val nicknameText: String) {
    init {
        require(nicknameText.isNotBlank()) { "사용자 이름은 빈칸이거나 공백 일 수 없습니다." }
    }
}
