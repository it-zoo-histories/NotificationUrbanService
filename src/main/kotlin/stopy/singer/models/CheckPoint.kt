package stopy.singer.models

import javax.persistence.*

@Entity
@Table(name = "checkPoints")
class CheckPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null

    val x: Long? = null

    val y: Long? = null

//    @ManyToOne
//    @JoinColumn(name = "id", table = "users")
//    val userId: Long? = null
}