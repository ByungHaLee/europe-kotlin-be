package study.europe.europekotlinbe.entity

import javax.persistence.*

@Entity
data class Todo (var title: String,
                 @Id @GeneratedValue(strategy= GenerationType.AUTO) var id: Long? = null)

