package com.itmo.mpa.entity

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "scale_type")
class ScaleType : LongIdEntity() {

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Type(type = "string-array")
    @Column(name = "names_from_scale", columnDefinition = "text[]", nullable = false)
    lateinit var names_from_scale: Array<String>
}
