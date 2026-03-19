package woowacourse.kanban.board.data

data class Tags(val tags: List<String> = emptyList()) {
    init {
        require(tags.size in 0..5) { "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다." }
        tags.forEach { tag -> require(tag.length in 1..5){ "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다." } }
    }
}
