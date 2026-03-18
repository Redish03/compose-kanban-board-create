package woowacourse.kanban.board.data

data class Task(
    val taskTitle: Title,
    val taskScript: Script = Script(""),
    val tags: Tags = Tags(emptyList()),
    val nickname: Nickname,
)

/*
* Title, Tags를 분리해야할까? 너무 많은 책임을 지는게 아닐까? 확장성을 고려해야할까?
* 분리하면 테스트가 훨씬 쉬워지고,
* 단점으론 생성시마다 호출해야하는 불편함이 있을것임
* 클래스 생성에 따른 성능적인 측면도 있을수도 있을수도?
* */
