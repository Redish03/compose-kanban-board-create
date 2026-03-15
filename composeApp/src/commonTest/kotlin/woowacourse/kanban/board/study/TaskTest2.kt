package woowacourse.kanban.board.study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import kotlin.test.Test
import kotlin.test.assertEquals

enum class TaskStatus(val string: String = "") {
    TODO("To-do"),
    IN_PROGRESS(),
    DONE()
}

// 1. 빈 껍데기 만들기
data class Task2(
    val assignee: String,
    val status: TaskStatus,
    val tags: List<String>? = null,
    val title: String,
    val description: String = "",
) {


    fun doesDescriptionExist() = description != ""

    fun doesTagsExist() = tags != null

    init {
        require(title.isNotEmpty()) { "빈 문자열일 수 없습니다." }
        require((tags?.size ?: 0) <= 5) { "태그는 5개까지만 생성 가능합니다." }
    }
}

class TaskTest2 {

    @Test
    fun `태스크는 제목, 설명, 태그, 상태, 담당자를 가진다`() {
        val task = Task2(
            title = "tdd 수업하기",
            description = "오늘 배운 내용을 복습하고 다음주제를 준비한다.",
            tags = listOf("공브", "Tdd"),
            status = TaskStatus.TODO,
            assignee = "레아",
        )

        assertThat(task.title).isEqualTo("tdd 수업하기")
        assertThat(task.description).isEqualTo("오늘 배운 내용을 복습하고 다음주제를 준비한다.")
        assertThat(task.tags).isEqualTo(listOf("공브", "Tdd"))
        assertThat(task.status).isEqualTo(TaskStatus.TODO)
        assertThat(task.assignee).isEqualTo("레아")
        // test 작성하기.(실패 확인)
        // Test가 통과하면 커밋 작성하기
    }

    @Test
    fun `제목이 빈 문자열이면 태스크 생성이 불가능하다`() {
        assertThatThrownBy {
            val task = Task2(
                title = "",
                description = "오늘 배운 내용을 복습하고 다음주제를 준비한다.",
                tags = listOf("공브", "Tdd"),
                status = TaskStatus.TODO,
                assignee = "레아",
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
        // 죄악 예시 : init에서 바로 throw IllegalArgumentException을 던지기
        // 그치만 이거는 통과하겠지만 다른 테스트가 실패하기 때문에, 리팩터링을 하자.

        // 커밋
    }

//    @Test
//    fun `태그는 최대 5개까지 생성 가능하다`() {
//        assertThatThrownBy {
//            val task = Task2(
//                title = "TDD 수업하기",
//                description = "오늘 배운 내용을 복습하고 다음주제를 준비한다.",
//                tags = listOf("공브", "Tdd", "tdd1", "tdd2"),
//                status = TaskStatus.TODO,
//                assignee = "레아",
//            )
//        }.isInstanceOf(IllegalArgumentException::class.java)
//    }

    @Test
    fun `태그가 5개가 넘으면 생성이 불가능하다 `() {
        assertThatThrownBy {
            val task = Task2(
                title = "",
                description = "오늘 배운 내용을 복습하고 다음주제를 준비한다.",
                tags = listOf("공브", "Tdd", "tdd1", "tdd2", "tdd3", "tdd4"),
                status = TaskStatus.TODO,
                assignee = "레아",
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }


    @Test
    fun `제목, 상태, 담당자로 태스크를 생성할 수 있다`() {
        val task = Task2(
            title = "tdd 수업하기",
            status = TaskStatus.TODO,
            assignee = "레아",
        )
        assertThat(task.title).isEqualTo("tdd 수업하기")
        assertThat(task.doesDescriptionExist()).isEqualTo(false)
        assertThat(task.doesTagsExist()).isEqualTo(false)
        assertThat(task.status).isEqualTo("TODO")
        assertThat(task.assignee).isEqualTo("레아")
    }

    @Test
    fun `상태를 지정하지 않으면 기본값은 TODO이다`() {
        val task = Task2(
            title = "tdd 수업하기",
            status = TaskStatus.TODO,
            assignee = "레아",
        )
        assertThat(task.title).isEqualTo("tdd 수업하기")
        assertThat(task.doesDescriptionExist()).isEqualTo(false)
        assertThat(task.doesTagsExist()).isEqualTo(false)
        assertThat(task.status).isEqualTo("TODO")
        assertThat(task.assignee).isEqualTo("레아")
    }

    @Test
    fun `같은 값으로 생성한 두 태스크가 같은가`() {
        val task = Task2(
            assignee = "레아",
            status = TaskStatus.TODO,
            title = "task2",
        )

        val task2 = Task2(
            assignee = "레아",
            status = TaskStatus.TODO,
            title = "task2",
        )

        assertEquals(task, task2)
    }

    // UI에서 검증못하는 테스트도 있고, Preview 에서도 거르지 못하는 것들도 있다.
    // TDD가 관심사를 분리를 해주고, 정확하게 이 시나리오들을
}