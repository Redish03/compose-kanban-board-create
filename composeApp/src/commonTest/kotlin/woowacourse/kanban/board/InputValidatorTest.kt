package woowacourse.kanban.board

import org.junit.Test
import kotlin.test.assertEquals

class InputValidatorTest {
    @Test
    fun `제목에 빈 값이 들어올 경우 제목을 입력하라는 안내문구가 나온다`() {
        val testString1 = ""
        val testString2 = "  "
        val testString3 = "\n"
        val testString4 = "\n\t"

        assertEquals(TITLE_ERROR_MESSAGE, InputValidator.validateTitle(testString1))
        assertEquals(TITLE_ERROR_MESSAGE, InputValidator.validateTitle(testString2))
        assertEquals(TITLE_ERROR_MESSAGE, InputValidator.validateTitle(testString3))
        assertEquals(TITLE_ERROR_MESSAGE, InputValidator.validateTitle(testString4))
    }

    @Test
    fun `제목이 입력된다면 null을 반환한다`() {
        val testString1 = "hello~"
        assertEquals(null, InputValidator.validateTitle(testString1))
    }

    @Test
    fun `태그가 비어있다면 null을 반환한다`() {
        val testString1 = ""
        val testString2 = "\n\t"
        val testString3 = "\n"
        val testString4 = "   "

        assertEquals(null, InputValidator.validateTagsAndWordCount(testString1))
        assertEquals(null, InputValidator.validateTagsAndWordCount(testString2))
        assertEquals(null, InputValidator.validateTagsAndWordCount(testString3))
        assertEquals(null, InputValidator.validateTagsAndWordCount(testString4))
    }

    @Test
    fun `5자 이상의 또는 5개 이상의 태그가 들어올 경우 에러메세지를 반환한다`() {
        val testString1 = "fiveword,overfive"
        val testString2 = "태그가길어요"
        val testString3 = "test1,test2,test3,test4,test5,test6"

        assertEquals(TAG_WORD_AND_LETTER_IN_FIVE, InputValidator.validateTagsAndWordCount(testString1))
        assertEquals(TAG_WORD_AND_LETTER_IN_FIVE, InputValidator.validateTagsAndWordCount(testString2))
        assertEquals(TAG_WORD_AND_LETTER_IN_FIVE, InputValidator.validateTagsAndWordCount(testString3))
    }

    @Test
    fun `정상적인 태그거나 값이 안들어 온 경우 null을 반환한다`() {
        val testString1 = ""
        val testString2 = "Tag1"
        val testString3 = "Tag1, Tag2, Tag3, Tag4, Tag5"

        assertEquals(null, InputValidator.validateTagsAndWordCount(testString1))
        assertEquals(null, InputValidator.validateTagsAndWordCount(testString2))
        assertEquals(null, InputValidator.validateTagsAndWordCount(testString3))
    }

    companion object {
        const val TITLE_ERROR_MESSAGE = "제목을 입력해 주세요."
        const val TAG_WORD_AND_LETTER_IN_FIVE = "태그는 5자 이내로 5개까지만 등록할 수 있습니다."
    }
}
