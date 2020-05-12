package com.itmo.mpa.entity

import com.itmo.mpa.entity.medicine.ActiveSubstance
import javax.persistence.*

@Entity
@Table(name = "adr")
class Adr : LongIdEntity() {

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "frequency_of_occurence", nullable = false)
    var frequency_of_occurence: Long = 0

    @Column(name = "the_severity_of_the_clinical_course", nullable = false)
    var the_severity_of_the_clinical_course: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_scale_type_for_the_severity_of_the_clinical_course", nullable = false)
    lateinit var scale_type_for_the_severity_of_the_clinical_course: ScaleType
    @OneToOne(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST, CascadeType.MERGE])

    @ManyToOne
    @JoinColumn(name = "id_scale_type_for_occurence_frequency", nullable = false)
    lateinit var scale_type_for_occurence_frequency: ScaleType

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(name = "adr_active_substance",
            joinColumns = [JoinColumn(name = "adr_id", nullable = false)],
            inverseJoinColumns = [JoinColumn(name = "active_substance_id", nullable = false)])
    lateinit var activeSubstances: Set<ActiveSubstance>
}
