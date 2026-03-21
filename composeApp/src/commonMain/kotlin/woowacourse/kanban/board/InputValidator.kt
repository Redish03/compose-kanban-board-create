package woowacourse.kanban.board

object InputValidator {
    private const val MIN_TAG_COUNT = 0
    private const val MAX_TAG_COUNT = 5
    private const val MIN_TAG_LETTER_COUNT = 1
    private const val MAX_TAG_LETTER_COUNT = 5
    private const val TAG_DELIMITER = ','

    fun validateTitle(value: String?): String? {
        if (value.isNullOrEmpty() || value.isBlank()) return "제목을 입력해 주세요."
        return null
    }

    fun validateDescription(value: String): String? = null

    fun validateTagsAndWordCount(value: String): String? {
        if (value.isBlank()) return null

        val tags = value.split(TAG_DELIMITER).map { it.trim() }
        if (tags.size !in MIN_TAG_COUNT..MAX_TAG_COUNT) return "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
        tags.forEach { tag ->
            if (tag.length !in MIN_TAG_LETTER_COUNT..MAX_TAG_LETTER_COUNT) return "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
        }
        return null
    }
}
