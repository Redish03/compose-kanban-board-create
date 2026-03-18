package woowacourse.kanban.board.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class TaskTest {
    @Test
    fun `빈 제목이 들어오면 IllegalArgumentException을 발생시킨다`() {
        val emptyTitle = ""
        val emptyTitle2 = "  "

        assertThrows(IllegalArgumentException::class.java) {
            Task(
                taskTitle = Title(emptyTitle),
                nickname = Nickname("사무엘"),
            )
        }
        assertThrows(IllegalArgumentException::class.java) {
            Task(
                taskTitle = Title(emptyTitle2),
                nickname = Nickname("사무엘"),
            )
        }
    }

    @Test
    fun `빈 닉네임이 들어오면 IllegalArgumentException을 발생시킨다`() {
        val emptyName = ""
        val emptyName2 = "  "

        assertThrows(IllegalArgumentException::class.java) { Task(taskTitle = Title("title"), nickname = Nickname(emptyName)) }
        assertThrows(IllegalArgumentException::class.java) { Task(taskTitle = Title("title"), nickname = Nickname(emptyName2)) }
    }

    @Test
    fun `태그에 5자 이상 또는 5개 이상의 태그가 들어올 경우 IllegalArgumentException을 발생시킨다`() {
        val wrongTag1 = listOf("fivetag", "overfive")
        val wrongTag2 = listOf("tag1", "tag2", "tag3", "tag4", "tag5", "tag6")

        assertThrows(IllegalArgumentException::class.java) {
            Task(
                taskTitle = Title("title"),
                nickname = Nickname("samel"),
                tags = Tags(wrongTag1),
            )
        }
        assertThrows(IllegalArgumentException::class.java) {
            Task(
                taskTitle = Title("title"),
                nickname = Nickname("samel"),
                tags = Tags(wrongTag2),
            )
        }
    }

    @Test
    fun `태그가 비어있거나 형식에 맞을 경우 Task를 생성한다`() {
        val task = Task(
            taskTitle = Title("title"),
            tags = Tags(emptyList()),
            nickname = Nickname("samuel"),
        )

        assertThat(task.taskTitle.titleText).isEqualTo("title")
    }
}
