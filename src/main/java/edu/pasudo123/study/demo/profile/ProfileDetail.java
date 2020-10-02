package edu.pasudo123.study.demo.profile;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "detail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "detail_info", columnDefinition = "VARCHAR(255)")
    private String detailInfo;

    public ProfileDetail(final String detailInfo) {
        this.detailInfo = detailInfo;
    }
}
