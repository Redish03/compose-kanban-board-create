package woowacourse.kanban.board.data

data class Tags(val tags: List<String> = emptyList()) {
    init {
        val validTags = tags.filter { it.isNotBlank() }
        require(validTags.size in 0..5) { "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다." }
        validTags.forEach { tag -> require(tag.length in 1..5){ "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다." } }
    }
}
