package edu.pasudo123.study.demo.profile;

import lombok.Getter;

public class ProfileDto {

    @Getter
    public static class Response {
        private Long id;
        private String name;
        private String regDate;
        private String detailInfo;

        public Response(final Profile profile) {
            this.id = profile.getId();
            this.name = profile.getName();
            this.regDate = profile.getRegDate().toString();
            this.detailInfo = profile.getDetail().getDetailInfo();
        }
    }
}
